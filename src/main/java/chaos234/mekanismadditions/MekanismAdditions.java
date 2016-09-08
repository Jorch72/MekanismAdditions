package chaos234.mekanismadditions;

import chaos234.mekanismadditions.common.CommonProxy;
import chaos234.mekanismadditions.common.MekanismAdditionsFluids;
import chaos234.mekanismadditions.common.MekanismAdditionsItems;
import mekanism.api.ItemRetriever;
import mekanism.api.util.*;
import mekanism.api.MekanismConfig;

import mekanism.api.gas.GasRegistry;
import mekanism.api.gas.GasStack;
import mekanism.api.recipe.RecipeHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.login.Configuration;

/**
 * Created by Marcel on 08.09.2016.
 */
@Mod(modid = MekanismAdditions.MODID, name = MekanismAdditions.MODNAME, version = MekanismAdditions.MODVERSION, dependencies = "required-after:Mekanism@[9.2.0.292]", useMetadata = true)
public class MekanismAdditions {
    /* Define some default vars */
    public static final String MODID = "mekanismadditions";
    public static final String MODNAME = "Mekansim Additions";
    public static final String MODVERSION = "1.0.0-beta.1";


    /* Mekansim Additions logger instance */
    public static Logger maLogger = LogManager.getLogger("Mekanism Additions");

    /* Mekanism Additions proxy instance */
    @SidedProxy(clientSide = "mekanismadditions.client.ClientProxy", serverSide = "mekanismadditions.common.CommonProxy")
    public static CommonProxy proxy;

    /* Mekanism Additions mod instance */
    @Instance("MekanismAdditions")
    public static MekanismAdditions instance;

    /* Mekanism Additions configuration instance */
    public static Configuration configuration;

    static {
        MekanismAdditionsFluids.register();
    }

    public void addRecipes() {

        ItemStack controlCircuit = ItemRetriever.getItem("ControlCircuit");

        CraftingManager.getInstance().getRecipeList().add(new ShapedRecipes(3, 3, new ItemStack(MekanismAdditionsItems.InformationTab, 1),
                " C ", "CBC", " C ", Character.valueOf('C'), stack , Character.valueOf('B'), Items.BOOK
        ));

        //secound way for heavy water
            // RecipeHelper.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidgas"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1));
        RecipeHelper.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1));
        RecipeHelper.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidrd"), 1));

        RecipeHelper.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidgas"), 1), new GasStack(GasRegistry.getGas("enrichedwater"), 1));
        RecipeHelper.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1), new GasStack(GasRegistry.getGas("enrichedwater"), 1));
        RecipeHelper.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1), new GasStack(GasRegistry.getGas("enrichedwatersnd"), 1));
        RecipeHelper.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidrd"), 1), new GasStack(GasRegistry.getGas("enrichedwaterrd"), 1));

        RecipeHelper.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("sulfurDioxideGas"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1));

    }
}
