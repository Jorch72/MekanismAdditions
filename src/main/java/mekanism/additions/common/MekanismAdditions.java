package mekanism.additions.common;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import io.netty.buffer.ByteBuf;
import mekanism.api.MekanismConfig;
import mekanism.api.gas.GasRegistry;
import mekanism.api.gas.GasStack;
import mekanism.common.Mekanism;
import mekanism.common.Tier;
import mekanism.common.Version;
import mekanism.common.base.IModule;
import mekanism.common.recipe.RecipeHandler;
import mekanism.common.recipe.ShapedMekanismRecipe;
import mekanism.common.util.MekanismUtils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fluids.FluidRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.lang.Object;

/**
 * Created by Marcel on 08.09.2016.
 */
@Mod(modid = MekanismAdditions.MODID, name = MekanismAdditions.MODNAME, version = MekanismAdditions.MODVERSION, dependencies = "required-after:Mekanism", useMetadata = true)
public class MekanismAdditions  implements IModule{

    /* Define some default vars */
    public static final String MODID = "mekanismadditions";
    public static final String MODNAME = "Mekansim Additions";
    public static final String MODVERSION = "9.1.1";
    public static Version versionNumber = new Version(9,1,1);


    /* Mekansim Additions logger instance */
    public static Logger maLogger = LogManager.getLogger("Mekanism Additions");

    /* Mekanism Additions proxy instance */
    @SidedProxy(clientSide = "mekanism.additions.client.AdditionsClientProxy", serverSide = "mekanism.additions.common.AdditionsCommonProxy")
    public static AdditionsCommonProxy proxy;

    /* Mekanism Additions mod instance */
    @Mod.Instance("MekanismAdditions")
    public static MekanismAdditions instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addItems();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        Mekanism.modulesLoaded.add(this);

        MinecraftForge.EVENT_BUS.register(this);

        //proxy.loadConfiguration();

        addRecipes();

        Mekanism.logger.info("[Mekansim Additions]: Module loaded.");
    }

    public void addRecipes() {
        CraftingManager.getInstance().getRecipeList().add(new ShapedMekanismRecipe(new ItemStack(AdditionsItems.InformationTab,1), new Object[]{
            " C ", "CBC", " C ", Character.valueOf('C'), MekanismUtils.getControlCircuit(Tier.BaseTier.BASIC), Character.valueOf('B'), Items.book
        }));

        //second way for heavy water
        // RecipeHelper.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidgas"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1));
        RecipeHandler.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1));
        RecipeHandler.addChemicalInfuserRecipe(new GasStack(GasRegistry.getGas("hydrogen"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfidrd"), 1));

        RecipeHandler.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidgas"), 1), new GasStack(GasRegistry.getGas("enrichedwater"), 1));
        RecipeHandler.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1), new GasStack(GasRegistry.getGas("enrichedwater"), 1));
        RecipeHandler.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidsnd"), 1), new GasStack(GasRegistry.getGas("enrichedwatersnd"), 1));
        RecipeHandler.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("enricheddihydrogensulfidrd"), 1), new GasStack(GasRegistry.getGas("enrichedwaterrd"), 1));

        RecipeHandler.addChemicalWasherRecipe(new GasStack(GasRegistry.getGas("sulfurDioxideGas"), 1), new GasStack(GasRegistry.getGas("enricheddihydrogensulfid"), 1));

        RecipeHandler.addElectrolyticSeparatorRecipe(FluidRegistry.getFluidStack("enrichedwater", 1000), 2 * MekanismConfig.usage.heavyWaterElectrolysisUsage, new GasStack(GasRegistry.getGas("deuterium"), 1), new GasStack(GasRegistry.getGas("oxygen"), 100));
        RecipeHandler.addElectrolyticSeparatorRecipe(FluidRegistry.getFluidStack("enrichedwatersnd", 100), 3 * MekanismConfig.usage.heavyWaterElectrolysisUsage, new GasStack(GasRegistry.getGas("deuterium"), 1), new GasStack(GasRegistry.getGas("oxygen"), 10));
        RecipeHandler.addElectrolyticSeparatorRecipe(FluidRegistry.getFluidStack("enrichedwaterrd", 10), 4 * MekanismConfig.usage.heavyWaterElectrolysisUsage, new GasStack(GasRegistry.getGas("deuterium"), 1), new GasStack(GasRegistry.getGas("oxygen"), 1));
    }

    public void addItems() {
        MekanismAdditions.proxy.preInit();

        if(Mekanism.configuration.hasChanged()) {
            Mekanism.configuration.save();
        }

        AdditionsItems.initializeItems();
        AdditionsItems.register();
        AdditionsFluids.register();
    }

    @Override
    public Version getVersion() {
        return versionNumber;
    }

    @Override
    public String getName() {
        return "Additions";
    }

    @Override
    public void writeConfig(ByteBuf byteBuf) throws IOException {

    }

    @Override
    public void readConfig(ByteBuf byteBuf) throws IOException {

    }

    @Override
    public void resetClient() {

    }
}
