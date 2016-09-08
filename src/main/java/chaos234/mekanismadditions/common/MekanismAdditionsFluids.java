package chaos234.mekanismadditions.common;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;

/**
 * Created by Marcel on 08.09.2016.
 */
public class MekanismAdditionsFluids {
    public static void register() {
        GasRegistry.register(new Gas("enrichedwater","mekanismadditions:liquid/LiquidEnrichedWater")).registerFluid();
        GasRegistry.register(new Gas("enrichedwatersnd","mekanismadditions:liquid/LiquidEnrichedWaterSnd")).registerFluid();
        GasRegistry.register(new Gas("enrichedwaterrd","mekanismadditions:liquid/LiquidEnrichedWaterRd")).registerFluid();
        GasRegistry.register(new Gas("dihydrogensulfid","mekanismadditions:liquid/LiquidEnrichedDihydrogenSulfidGas")).registerFluid();

        GasRegistry.register(new Gas("enricheddihydrogensulfid","mekanismadditions:liquid/LiquidEnrichedDihydrogenSulfidGas")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidsnd","mekanismadditions:liquid/LiquidEnrichedDihydrogenSulfidSnd")).registerFluid();
        GasRegistry.register(new Gas("enricheddihydrogensulfidrd","mekanismadditions:liquid/LiquidEnrichedDihydrogenSulfidRd")).registerFluid();
    }
}
