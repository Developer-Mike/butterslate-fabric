package mike.butterslate.mixin;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractBlock.class)
public interface BlockSettingsAccessor {
    @Accessor
    AbstractBlock.Settings getSettings();

    @Accessor
    @Mutable
    void setResistance(float resistance);
}
