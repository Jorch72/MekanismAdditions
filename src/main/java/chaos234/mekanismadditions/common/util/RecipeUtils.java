package chaos234.mekanismadditions.common.util;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

        import chaos234.mekanismadditions.common.recipe.ShapedMekanismAdditionsRecipe;
        import mekanism.api.energy.IEnergizedItem;
        import mekanism.api.gas.GasStack;
        import mekanism.api.gas.IGasItem;
        import mekanism.api.util.StackUtils;

        import net.minecraft.block.Block;
        import net.minecraft.inventory.InventoryCrafting;
        import net.minecraft.item.Item;
        import net.minecraft.item.ItemStack;
        import net.minecraft.item.crafting.CraftingManager;
        import net.minecraft.item.crafting.IRecipe;
        import net.minecraft.nbt.NBTTagCompound;
        import net.minecraft.util.ResourceLocation;
        import net.minecraft.world.World;
        import net.minecraftforge.oredict.OreDictionary;

public class RecipeUtils {
    public static boolean areItemsEqualForCrafting(ItemStack target, ItemStack input) {
        if(target == null && input != null || target != null && input == null) {
            return false;
        }
        else if(target == null && input == null) {
            return true;
        }

        if(target.getItem() != input.getItem()) {
            return false;
        }

        if(target.getItemDamage() != input.getItemDamage() && target.getItemDamage() != OreDictionary.WILDCARD_VALUE) {
            return false;
        }

        return true;
    }



    public static ItemStack getCraftingResult(InventoryCrafting inv, ItemStack toReturn) {
        if(toReturn.getItem() instanceof IEnergizedItem) {
            double energyFound = 0;

            for(int i = 0; i < 9; i++) {
                ItemStack itemstack = inv.getStackInSlot(i);

                if(itemstack != null && itemstack.getItem() instanceof IEnergizedItem) {
                    energyFound += ((IEnergizedItem)itemstack.getItem()).getEnergy(itemstack);
                }
            }

            ((IEnergizedItem)toReturn.getItem()).setEnergy(toReturn, Math.min(((IEnergizedItem)toReturn.getItem()).getMaxEnergy(toReturn), energyFound));
        }

        if(toReturn.getItem() instanceof IGasItem) {
            GasStack gasFound = null;

            for(int i = 0; i < 9; i++) {
                ItemStack itemstack = inv.getStackInSlot(i);

                if(itemstack != null && itemstack.getItem() instanceof IGasItem) {
                    GasStack stored = ((IGasItem)itemstack.getItem()).getGas(itemstack);

                    if(stored != null) {
                        if(!((IGasItem)toReturn.getItem()).canReceiveGas(toReturn, stored.getGas())) {
                            return null;
                        }

                        if(gasFound == null) {
                            gasFound = stored;
                        } else {
                            if(gasFound.getGas() != stored.getGas()) {
                                return null;
                            }

                            gasFound.amount += stored.amount;
                        }
                    }
                }
            }

            if(gasFound != null) {
                gasFound.amount = Math.min(((IGasItem)toReturn.getItem()).getMaxGas(toReturn), gasFound.amount);
                ((IGasItem)toReturn.getItem()).setGas(toReturn, gasFound);
            }
        }
        return toReturn;
    }

    public static ItemStack loadRecipeItemStack(NBTTagCompound nbtTags) {
        int meta = 0;
        int amount = 1;

        if(nbtTags.hasKey("meta")) {
            meta = nbtTags.getInteger("meta");
        }

        if(nbtTags.hasKey("amount")) {
            amount = nbtTags.getInteger("amount");
        }

        if(nbtTags.hasKey("itemstack")) {
            return ItemStack.loadItemStackFromNBT(nbtTags.getCompoundTag("itemstack"));
        }
        else if(nbtTags.hasKey("itemname")) {
            Object obj = Item.REGISTRY.getObject(new ResourceLocation(nbtTags.getString("itemname")));

            if(obj != null) {
                return new ItemStack((Item)obj, amount, meta);
            }
        } else if(nbtTags.hasKey("blockname")) {
            Object obj = Block.REGISTRY.getObject(new ResourceLocation(nbtTags.getString("blockname")));

            if(obj != null) {
                return new ItemStack((Block)obj, amount, meta);
            }
        }

        return null;
    }

    public static boolean removeRecipes(ItemStack stack) {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        for(Iterator<IRecipe> iter = recipes.iterator(); iter.hasNext();) {
            IRecipe iterRecipe = iter.next();

            if(iterRecipe instanceof ShapedMekanismAdditionsRecipe) {
                if(StackUtils.equalsWildcard(stack, iterRecipe.getRecipeOutput())) {
                    iter.remove();
                }
            }
        }

        return false;
    }

    public static IRecipe getRecipeFromGrid(InventoryCrafting inv, World world) {
        List<IRecipe> list = new ArrayList<IRecipe>(CraftingManager.getInstance().getRecipeList());

        for(Iterator<IRecipe> iter = list.iterator(); iter.hasNext();) {
            IRecipe recipe = iter.next();

            if(recipe.matches(inv, world)) {
                return recipe;
            }
        }

        return null;
    }
}