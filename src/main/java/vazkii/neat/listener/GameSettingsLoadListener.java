package vazkii.neat.listener;

import net.minecraft.client.GameSettings;

public interface GameSettingsLoadListener {
    void onLoadOptions(GameSettings gameSettings);
}
