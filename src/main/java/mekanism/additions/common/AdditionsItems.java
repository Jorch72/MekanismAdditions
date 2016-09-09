package mekanism.additions.common;

import mekanism.additions.common.item.ItemInformationTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Created by Marcel on 08.09.2016.
 */
@ObjectHolder("MekanismAdditions")
public class AdditionsItems {

    public static Item InformationTab = new ItemInformationTab();

    public static void initializeItems() {
        InformationTab = init(new ItemInformationTab(),"InformationTab");
    }

    public static void register() {
        GameRegistry.register(InformationTab);

        MekanismAdditions.proxy.registerItemRenders();
    }

    public static Item init(Item item, String name) {
        return item.setUnlocalizedName(name).setRegistryName("mekanismadditions:" + name);
    }
}
