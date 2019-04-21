package vazkii.neat;

import de.guntram.mcmod.fabrictools.KeyBindingManager;
import net.fabricmc.api.ClientModInitializer;
import vazkii.neat.listener.RenderWorldLastListener;

public class NeatCore implements ClientModInitializer {
    
    public static RenderWorldLastListener renderer;
    
    @Override
    public void onInitializeClient() {
        renderer=new HealthBarRenderer();
        ToggleKeybind keyBinder = new ToggleKeybind();
        keyBinder.setKeyBindings();
        KeyBindingManager.register(keyBinder);
    }
}
