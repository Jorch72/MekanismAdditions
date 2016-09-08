package chaos234.mekanismadditions.common;

import chaos234.mekanismadditions.common.item.ItemInformationTab;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * Created by Marcel on 08.09.2016.
 */
@ObjectHolder("MekanismAdditions")
public class MekanismAdditionsItems {

    public static final Item InformationTab = new ItemInformationTab();

    /**
     * Adds and registers all items.
     */
    public static void register() {
        GameRegistry.register(init(InformationTab, "InformationTab"));

    }

    public static Item init(Item item, String name) {
        return item.setUnlocalizedName(name).setRegistryName("mekanismadditions:" + name);
    }
}
