package mekanism.additions.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mekanism.client.gui.GuiMekanism;
import net.minecraft.inventory.Container;

/**
 * Created by Marcel on 09.09.2016.
 */
@SideOnly(Side.CLIENT)
public class GuiInformationTab extends GuiMekanism {

    public GuiInformationTab(Container container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
