package vazkii.neat;

import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public class NeatConfig {
	
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

	// TODO: config
}
