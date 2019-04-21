package vazkii.neat;

import de.guntram.mcmod.fabrictools.ConfigChangedEvent;
import de.guntram.mcmod.fabrictools.Configuration;
import de.guntram.mcmod.fabrictools.ModConfigurationHandler;
import java.io.File;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class NeatConfig implements ModConfigurationHandler {

    private static Configuration config;
    private static String configFileName;

	public static boolean draw = true;
	
	public static int maxDistance = 24;
	public static boolean renderInF1 = false;
	public static double heightAbove = 0.6;
	public static boolean drawBackground = true;
	public static int backgroundPadding = 2;
	public static int backgroundHeight = 6;
	public static int barHeight = 4;
	public static int plateSize = 25;
	public static int plateSizeBoss = 50;
	public static boolean showAttributes = true;
	public static boolean showArmor = true;
	public static boolean groupArmor = true;
	public static boolean colorByType = false;
	public static int hpTextHeight = 14;
	public static boolean showMaxHP = true;
	public static boolean showCurrentHP = true;
	public static boolean showPercentage = true;
	public static boolean showOnPlayers = true;
	public static boolean showOnBosses = true;
	public static boolean showOnlyFocused = false;
	public static boolean enableDebugInfo = true;

	public static List<Identifier> blacklist = Arrays.asList(new Identifier("shulker"), new Identifier("armor_stand"));

    public void load(final File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            configFileName=configFile.getPath();
            loadConfig();
        }
    }
    
    private void loadConfig() {
        maxDistance     = config.getInt("Max. render distance", Configuration.CATEGORY_CLIENT, maxDistance, 10, 200, "Maximum distance to render Unit Frame");
        renderInF1      = config.getBoolean("Render in F1", Configuration.CATEGORY_CLIENT, renderInF1, "Render even when UI is disabled");
        heightAbove     = config.getFloat("Height above", Configuration.CATEGORY_CLIENT, (float) heightAbove, 0, 3, "Height above entity");
        drawBackground  = config.getBoolean("Draw background", Configuration.CATEGORY_CLIENT, drawBackground, "Draw background behind text");
        backgroundHeight= config.getInt("Background height", Configuration.CATEGORY_CLIENT, backgroundHeight, 2, 10, "Background height");
        barHeight       = config.getInt("Bar height", Configuration.CATEGORY_CLIENT, barHeight, 2, 10, "Bar height");
        plateSize       = config.getInt("Plate size", Configuration.CATEGORY_CLIENT, plateSize, 10, 40, "Plate height (normal mobs)");
        plateSizeBoss   = config.getInt("Plate size bosses", Configuration.CATEGORY_CLIENT, plateSizeBoss, 20, 100, "Plate height (boss mobs)");
        showAttributes  = config.getBoolean("Show mob types", Configuration.CATEGORY_CLIENT, showAttributes, "Show mob type icons");
        showArmor       = config.getBoolean("Show armor", Configuration.CATEGORY_CLIENT, showArmor, "Show armor");
        groupArmor      = config.getBoolean("Group armor", Configuration.CATEGORY_CLIENT, groupArmor, "Group Armor (condense 5 iron icons into 1 diamond icon");
        colorByType     = config.getBoolean("Health bar color types", Configuration.CATEGORY_CLIENT, colorByType, "Color Health Bar by Type (instead of health percentage)");
        hpTextHeight    = config.getInt("Hit point text height", Configuration.CATEGORY_CLIENT, hpTextHeight, 10, 30, "Height of hit point text display");
        showMaxHP       = config.getBoolean("Show maximum HP", Configuration.CATEGORY_CLIENT, showMaxHP, "Show maximum mob hit points");
        showCurrentHP   = config.getBoolean("Show current HP", Configuration.CATEGORY_CLIENT, showCurrentHP, "Show current mob hit points");
        showPercentage  = config.getBoolean("Show percentage HP", Configuration.CATEGORY_CLIENT, showPercentage, "Show percentage of current to maximum hit points");
        showOnPlayers   = config.getBoolean("Show on players", Configuration.CATEGORY_CLIENT, showOnPlayers, "Show unit frames on players");
        showOnBosses    = config.getBoolean("Show on bosses", Configuration.CATEGORY_CLIENT, showOnBosses, "Show unit frames on bosses");
        showOnlyFocused = config.getBoolean("Show only focused", Configuration.CATEGORY_CLIENT, showOnlyFocused, "Show only one unit frame on the entity the player is looking at");
        
        if (config.hasChanged())
            config.save();
    }

    @Override
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(NeatCore.MODNAME)) {
            loadConfig();
        }
    }

    @Override
    public Configuration getConfig() {
        return config;
    }
}
