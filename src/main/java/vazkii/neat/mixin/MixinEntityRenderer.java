package vazkii.neat.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import org.dimdev.riftloader.RiftLoader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.neat.listener.RenderWorldLastListener;

@Mixin(GameRenderer.class)
public class MixinEntityRenderer {
    @Shadow @Final private Minecraft mc;

    @Inject(method = "updateCameraAndRender(FJ)V", at = @At(value = "INVOKE_STRING", target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V", args = "ldc=hand"))
    private void onUpdateCameraAndRender(float partialTicks, long finishTimeNano, CallbackInfo ci) {
        for (RenderWorldLastListener listener : RiftLoader.instance.getListeners(RenderWorldLastListener.class)) {
            listener.onRenderWorldLast(mc.gameRenderer, partialTicks);
        }
    }
}
