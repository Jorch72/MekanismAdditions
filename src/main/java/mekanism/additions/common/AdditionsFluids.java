package mekanism.additions.common;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;

/**
 * Created by Marcel on 08.09.2016.
 */
public class AdditionsFluids {
    public static void register() {
        GasRegistry.register(new Gas("enrichedwater","mekanismadditions:blocks/liquids/LiquidEnrichedWater")).registerFluid();
        GasRegistry.register(new Gas("enrichedwatersnd","mekanismadditions:blocks/liquids/LiquidEnrichedWaterSnd")).registerFluid();
        GasRegistry.register(new Gas("enrichedwaterrd","mekanismadditions:blocks/liquids/LiquidEnrichedWaterRd")).registerFluid();
        GasRegistry.register(new Gas("dihydrogensulfid","mekanismadditions:blocks/liquids/LiquidEnrichedDihydrogenSulfidGas")).registerFluid();

        GasRegistry.register(new Gas("enricheddihydrogensulfid","mekanismadditions:blocks/liquids/LiquidEnrichedDihydrogenSulfidGas")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidsnd","mekanismadditions:blocks/liquids/LiquidEnrichedDihydrogenSulfidSnd")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidrd","mekanismadditions:blocks/liquids/LiquidEnrichedDihydrogenSulfidRd")).registerFluid();
    }
}
