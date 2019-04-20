package vazkii.neat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.client.settings.KeyBinding;
import org.dimdev.rift.listener.client.KeyBindingAdder;
import org.dimdev.rift.listener.client.KeybindHandler;
import org.lwjgl.glfw.GLFW;

public class ToggleKeybind implements KeyBindingAdder, KeybindHandler {

	KeyBinding key;

    public ToggleKeybind() {
	}

    @Override
	public void processKeybinds() {
        if (key.isPressed()) {
			NeatConfig.draw = !NeatConfig.draw;
        }
	}

    @Override
    public Collection<? extends KeyBinding> getKeyBindings() {
        List<KeyBinding> myBindings=new ArrayList();
        myBindings.add(key = new KeyBinding("neat.keybind.toggle", GLFW.GLFW_KEY_UNKNOWN, "key.categories.ui"));
        return myBindings;        
    }
}
