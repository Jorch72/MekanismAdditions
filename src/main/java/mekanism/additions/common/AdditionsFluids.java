package mekanism.additions.common;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;

/**
 * Created by Marcel on 08.09.2016.
 */
public class AdditionsFluids {
    public static void register() {

        //GasRegistry.register(new Gas("enrichedwater")).registerFluid();
        GasRegistry.register(new Gas("enrichedwatersnd")).registerFluid();
        GasRegistry.register(new Gas("enrichedwaterrd")).registerFluid();
        GasRegistry.register(new Gas("dihydrogensulfid")).registerFluid();

        GasRegistry.register(new Gas("enricheddihydrogensulfid")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidsnd")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidrd")).registerFluid();
    }
}
