package vazkii.neat;

import de.guntram.mcmod.fabrictools.ConfigurationProvider;
import de.guntram.mcmod.fabrictools.KeyBindingManager;
import net.fabricmc.api.ClientModInitializer;
import vazkii.neat.listener.RenderWorldLastListener;

public class NeatCore implements ClientModInitializer {
    
    public static RenderWorldLastListener renderer;
    public static final String MODNAME = "NeatForFabric";
    public static final String MODID = "neat";
    
    @Override
    public void onInitializeClient() {
        renderer=new HealthBarRenderer();
        ToggleKeybind keyBinder = new ToggleKeybind();
        keyBinder.setKeyBindings();
        KeyBindingManager.register(keyBinder);
        
        NeatConfig confHandler = new NeatConfig();
        ConfigurationProvider.register(MODNAME, confHandler);
        confHandler.load(ConfigurationProvider.getSuggestedFile("neat"));
    }
}
