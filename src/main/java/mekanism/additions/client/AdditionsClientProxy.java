package mekanism.additions.client;

import mekanism.additions.common.AdditionsCommonProxy;
import mekanism.additions.common.AdditionsItems;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.item.Item;

/**
 * Created by Marcel on 09.09.2016.
 */
public class AdditionsClientProxy extends AdditionsCommonProxy{
    @Override
    public void registerItemRenders() {
        registerItemRender(AdditionsItems.InformationTab);
    }

    public void registerItemRender(Item item) {
        MekanismRenderer.registerItemRender("mekanismadditions", item);
    }

}
