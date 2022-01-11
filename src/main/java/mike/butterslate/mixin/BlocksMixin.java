package mike.butterslate.mixin;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;


@Mixin(Blocks.class)
public class BlocksMixin {
    private static Set<String> blocksToInject = null;
    private static final float stoneHardness = 1.5f;
    private static final float stoneResistance = 6.0f;

    @Inject(method = "register", at = @At("HEAD"))
    private static void register(String id, Block block, CallbackInfoReturnable<Block> cir) {
        if (blocksToInject == null) blocksToInject = Set.of(
                "deepslate",
                "coal_ore", "deepslate_coal_ore",
                "copper_ore", "deepslate_copper_ore",
                "lapis_ore", "deepslate_lapis_ore",
                "iron_ore", "deepslate_iron_ore",
                "gold_ore", "deepslate_gold_ore",
                "redstone_ore", "deepslate_redstone_ore",
                "diamond_ore", "deepslate_diamond_ore",
                "emerald_ore", "deepslate_emerald_ore"
        );

        if (blocksToInject.contains(id)) {
            setStrength(block, stoneHardness, stoneResistance);
        }
    }

    private static void setStrength(Block block, float hardness, float resistance) {
        ((BlockStateAccessor) block.getDefaultState()).setHardness(hardness);
        ((BlockSettingsAccessor) block).setResistance(resistance);

        ((BlockSettingsAccessor) block).getSettings().strength(hardness, resistance);
    }
}
