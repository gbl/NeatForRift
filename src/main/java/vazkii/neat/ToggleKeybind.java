package vazkii.neat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.dimdev.rift.listener.client.ClientTickable;

public class ToggleKeybind implements ClientTickable {

	KeyBinding key;
	boolean down;
	
	public ToggleKeybind() {
		key = new KeyBinding("neat.keybind.toggle", -1, "key.categories.misc");
		Minecraft.getMinecraft().gameSettings.keyBindings = ArrayUtils.add(Minecraft.getMinecraft().gameSettings.keyBindings, key);
	}

	@Override
	public void clientTick() {
		Minecraft mc = Minecraft.getMinecraft();
		boolean wasDown = down;
		down = key.isKeyDown();
		if(mc.mouseHelper.isMouseFocused() && down && !wasDown)
			NeatConfig.draw = !NeatConfig.draw;
	}
	
}
