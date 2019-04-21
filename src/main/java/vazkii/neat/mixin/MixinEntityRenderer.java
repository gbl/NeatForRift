package vazkii.neat.mixin;

import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.neat.NeatCore;


@Mixin(GameRenderer.class)
public abstract class MixinEntityRenderer {

    @Inject(method="renderCenter(FJ)V",
            at=@At(value="INVOKE_STRING",
                   target="Lnet/minecraft/util/profiler/Profiler;swap(Ljava/lang/String;)V",
                   args= { "ldc=hand" }
            )
    )
    private void onRenderWorldLast(float partialTicks, long nanoTime, CallbackInfo ci) {
        NeatCore.renderer.onRenderWorldLast(partialTicks);
    }
}
