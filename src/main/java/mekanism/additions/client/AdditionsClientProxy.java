package mekanism.additions.client;

import mekanism.additions.client.render.AdditionsRender;
import mekanism.additions.common.AdditionsCommonProxy;
import mekanism.additions.common.AdditionsItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Marcel on 09.09.2016.
 */
public class AdditionsClientProxy extends AdditionsCommonProxy{
    @Override
    public void registerItemRenders() {
        AdditionsRender.renderItem(new ItemStack(AdditionsItems.InformationTab, 1));
    }

    @Override
    public void preInit() {
        AdditionsRender.init();
    }

    @Override
    public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
        /*switch (ID) {
            case 0:
                return new GuiInformationTab(container);
        }*/
        return null;
    }
}
