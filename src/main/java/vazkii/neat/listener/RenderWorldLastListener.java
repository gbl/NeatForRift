package vazkii.neat.listener;

import net.minecraft.client.renderer.RenderGlobal;

public interface RenderWorldLastListener {
    void onRenderWorldLast(RenderGlobal renderGlobal, float partialTicks);
}
