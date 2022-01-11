package mike.butterslate.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractBlock.AbstractBlockState.class)
public interface BlockStateAccessor {
    @Accessor
    @Mutable
    void setHardness(float hardness);
}
