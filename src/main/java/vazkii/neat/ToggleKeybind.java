package vazkii.neat;

import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.dimdev.rift.listener.client.KeybindHandler;
import vazkii.neat.listener.GameSettingsLoadListener;

public class ToggleKeybind implements GameSettingsLoadListener, KeybindHandler {

	KeyBinding key;
	boolean down;
	
	public ToggleKeybind() {
		key = new KeyBinding("neat.keybind.toggle", -1, "key.categories.misc");
	}

	@Override
	public void onLoadOptions(GameSettings gameSettings) {
		gameSettings.keyBindings = ArrayUtils.add(gameSettings.keyBindings, key);
	}

	@Override
	public void processKeybinds() {
		Minecraft mc = Minecraft.getInstance();
		boolean wasDown = down;
		down = key.isKeyDown();
		if(mc.mouseHelper.isMouseGrabbed() && down && !wasDown)
			NeatConfig.draw = !NeatConfig.draw;
	}
	
}
