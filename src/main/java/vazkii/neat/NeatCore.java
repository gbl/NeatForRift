package vazkii.neat;

import org.dimdev.riftloader.listener.InitializationListener;
import org.spongepowered.asm.mixin.Mixins;

public class NeatCore implements InitializationListener {
    @Override
    public void onInitialization() {
        Mixins.addConfiguration("mixins.neat.json");
    }
}
