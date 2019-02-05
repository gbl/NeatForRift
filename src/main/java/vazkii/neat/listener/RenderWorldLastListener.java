package vazkii.neat.listener;

import net.minecraft.client.renderer.GameRenderer;

public interface RenderWorldLastListener {
    void onRenderWorldLast(GameRenderer renderGame, float partialTicks);
}
