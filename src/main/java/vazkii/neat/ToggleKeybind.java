package vazkii.neat;

import de.guntram.mcmod.fabrictools.KeyBindingHandler;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.StringTextComponent;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class ToggleKeybind implements KeyBindingHandler {

	FabricKeyBinding key;

    public ToggleKeybind() {
	}

    @Override
	public void processKeyBinds() {
        if (key.wasPressed()) {
			NeatConfig.draw = !NeatConfig.draw;
            MinecraftClient.getInstance().player.appendCommandFeedback(new StringTextComponent("Neat draw is "+(NeatConfig.draw ? "on" : "off")));
        }
	}

    public void setKeyBindings() {
        String category = "key.categories.ui";
        KeyBindingRegistry.INSTANCE.addCategory(category);
        KeyBindingRegistry.INSTANCE.register(
        key=FabricKeyBinding.Builder
            .create(new Identifier("neat.keybind.toggle"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, category)
                .build());
    }
}
