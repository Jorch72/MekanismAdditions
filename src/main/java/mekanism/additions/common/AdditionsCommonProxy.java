package mekanism.additions.common;

import mekanism.common.base.IGuiProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

/**
 * Created by Marcel on 09.09.2016.
 */
public class AdditionsCommonProxy implements IGuiProvider{

    public void registerItemRenders() {}

    public void preInit() {}

    @Override
    public Container getServerGui(int i, EntityPlayer entityPlayer, World world, int i1, int i2, int i3) {
        return null;
    }

    @Override
    public Object getClientGui(int i, EntityPlayer entityPlayer, World world, int i1, int i2, int i3) {
        return null;
    }
}
