package mekanism.additions.common;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import mekanism.additions.common.item.ItemInformationTab;
import net.minecraft.item.Item;


/**
 * Created by Marcel on 08.09.2016.
 */
@ObjectHolder("MekanismAdditions")
public class AdditionsItems {

    public static Item InformationTab;

    public static void initializeItems() {
        InformationTab = new ItemInformationTab().setUnlocalizedName("InformationTab");
    }

    public static void register() {
        GameRegistry.registerItem(InformationTab, "InformationTab");

        MekanismAdditions.proxy.registerItemRenders();
    }
}
