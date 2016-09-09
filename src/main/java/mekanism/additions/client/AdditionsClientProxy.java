package mekanism.additions.client;

import mekanism.additions.client.render.AdditionsRender;
import mekanism.additions.common.AdditionsCommonProxy;
import mekanism.additions.common.AdditionsItems;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.item.ItemStack;

/**
 * Created by Marcel on 09.09.2016.
 */
public class AdditionsClientProxy extends AdditionsCommonProxy{
    @Override
    public void registerItemRenders() {
        MekanismRenderer.renderItem(new ItemStack(AdditionsItems.InformationTab, 1));
    }

    @Override
    public void preInit() {
        AdditionsRender.init();
    }
}
