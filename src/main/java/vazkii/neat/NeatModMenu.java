package vazkii.neat;

import de.guntram.mcmod.fabrictools.ConfigurationProvider;
import de.guntram.mcmod.fabrictools.GuiModOptions;
import io.github.prospector.modmenu.api.ModMenuApi;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.client.gui.Screen;

public class NeatModMenu implements ModMenuApi
{
    @Override
    public String getModId() {
        return NeatCore.MODID;
    }

    @Override
    public Optional<Supplier<Screen>> getConfigScreen(Screen screen) {
        return Optional.of(new GuiModOptions(screen, NeatCore.MODNAME, ConfigurationProvider.getHandler(NeatCore.MODNAME)));
    }
}
