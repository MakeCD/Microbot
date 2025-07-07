package net.runelite.client.plugins.microbot.MKE.wintertodt;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.plugins.microbot.util.misc.Rs2Food;
import net.runelite.client.plugins.microbot.MKE.wintertodt.enums.Brazier;

/**
 * Configuration interface for the Wintertodt bot plugin.
 * Provides comprehensive settings for customizing bot behavior including
 * food management, brazier preferences, and various gameplay options.
 */
@ConfigGroup("wintertodt")
public interface MKE_WintertodtConfig extends Config {

    // Configuration sections for better organization
    @ConfigSection(
            name = "General Settings",
            description = "General bot behavior and gameplay options",
            position = 0
    )
    String generalSection = "general";

    @ConfigSection(
            name = "🍺 Rejuvenation Potions (RECOMMENDED)",
            description = "Use FREE rejuvenation potions for healing - automatically crafted inside Wintertodt from supply crates! More efficient than food.",
            position = 1
    )
    String potionSection = "potions";

    @ConfigSection(
            name = "🍖 Food Management (Alternative)",
            description = "Use regular food for healing - automatically gathered from bank. Less efficient but works without quest requirements.",
            position = 2
    )
    String foodSection = "food";

    @ConfigSection(
            name = "Brazier Management",
            description = "Brazier location and maintenance preferences",
            position = 3
    )
    String brazierSection = "brazier";

    @ConfigSection(
            name = "🛌 Custom Break System",
            description = "Smart break management with AFK and logout breaks for enhanced anti-detection",
            position = 4
    )
    String breakSection = "breaks";

    @ConfigSection(
            name = "Advanced Options",
            description = "Advanced timing and behavior customization",
            position = 5
    )
    String advancedSection = "advanced";

    @ConfigSection(
            name = "🏆 Reward Cart Looting",
            description = "Automatically collect rewards from the Wintertodt reward cart when you have enough points",
            position = 6
    )
    String rewardCartSection = "rewardCart";

    // General Settings
    @ConfigItem(
            keyName = "mke_wintertodt_requirements",
            name = "⚠️ REQUIREMENTS (READ FIRST!)",
            description = "Essential requirements that must be met before using this bot",
            position = 0,
            section = generalSection
    )
    default String MKE_WINTERTODT_REQUIREMENTS() {
        return "🔴 MANDATORY REQUIREMENTS:\n\n" +
                "✅ MEMBERSHIP: Must have active membership\n" +
                "✅ FIREMAKING LEVEL: Minimum level 50 required\n" +
                "✅ WARM GEAR: At least 4 warm clothing pieces in bank/worn\n" +
                "   Examples: Pyromancer outfit, Santa outfit, Hunter gear (Larupia/Graahk/Kyatt),\n" +
                "   Warm gloves, Woolly hat/scarf, Fire cape, Clue hunter gear, Animal costumes\n" +
                "✅ ESSENTIAL TOOLS in bank/inventory:\n" +
                "   • Any axe (Bronze axe minimum)\n" +
                "   • Knife\n" +
                "   • Hammer\n" +
                "   • Tinderbox (only if you don't have Bruma torch)\n\n" +
                "✅ HEALING METHOD (Choose ONE):\n" +
                "   🥄 POTIONS (RECOMMENDED): Complete 'Druidic Ritual' quest\n" +
                "      → Enable 'Rejuvenation Potions' below\n" +
                "      → No food needed - bot crafts potions automatically!\n" +
                "   🍖 FOOD (Alternative): Have selected food type in bank\n" +
                "      → Enable 'Food Management' below\n" +
                "      → Bot will withdraw food automatically\n\n" +
                "🎯 IF ALL REQUIREMENTS ARE MET:\n" +
                "You can start this script ANYWHERE and it will handle everything!\n" +
                "The bot will automatically navigate to Wintertodt, equip optimal gear,\n" +
                "and manage the entire activity for you.";
    }

    @ConfigItem(
            keyName = "wintertodt_guide",
            name = "Setup Instructions",
            description = "How to properly set up and use this plugin",
            position = 1,
            section = generalSection
    )
    default String WINTERTOD_GUIDE() {
        return "1. Ensure all requirements above are met!\n" +
                "2. Choose EITHER potions OR food (potions recommended!)\n" +
                "3. Configure your preferred brazier location\n" +
                "4. Enable desired options (fletching, fixing, etc.)\n" +
                "5. Start the plugin anywhere and let it run!";
    }

    @ConfigItem(
            keyName = "RelightBrazier",
            name = "Relight Braziers",
            description = "Automatically relight braziers when they go out",
            position = 2,
            section = generalSection
    )
    default boolean relightBrazier() {
        return true;
    }

    @ConfigItem(
            keyName = "FletchRoots",
            name = "Fletch Roots to Kindling",
            description = "Convert bruma roots to kindling for better XP and points",
            position = 3,
            section = generalSection
    )
    default boolean fletchRoots() {
        return true;
    }

    @ConfigItem(
            keyName = "FixBrazier",
            name = "Fix Broken Braziers",
            description = "Repair broken braziers",
            position = 4,
            section = generalSection
    )
    default boolean fixBrazier() {
        return true;
    }

    // Rejuvenation Potions Section
    @ConfigItem(
            keyName = "RejuvenationPotions",
            name = "⚗️ Enable Rejuvenation Potions (RECOMMENDED)",
            description = "Use FREE rejuvenation potions for optimal Wintertodt experience! The bot automatically crafts them inside Wintertodt using materials from supply crates. Requires 'Druidic Ritual' quest completion.",
            position = 1,
            section = potionSection
    )
    default boolean rejuvenationPotions() {
        return true;
    }

    @ConfigItem(
            keyName = "PotionBenefits",
            name = "✨ Why Potions Are Better",
            description = "Benefits of using rejuvenation potions over food",
            position = 2,
            section = potionSection
    )
    default String potionBenefits() {
        return "• 100% FREE - crafted from crate materials\n" +
                "• More warmth per use than food\n" +
                "• Takes less inventory space\n" +
                "• No banking required - bot crafts them inside Wintertodt\n" +
                "• More efficient and faster gameplay";
    }

    @ConfigItem(
            keyName = "PotionInfo",
            name = "📋 How It Works",
            description = "Requirements and automation details for rejuvenation potions",
            position = 3,
            section = potionSection
    )
    default String potionInfo() {
        return "QUEST REQUIREMENT: 'Druidic Ritual' must be completed\n\n" +
                "HOW IT WORKS:\n" +
                "1. Bot gets concoctions from crate inside wintertodt\n" +
                "2. Gets bruma herbs from sprouting roots\n" +
                "3. Automatically crafts rejuvenation potions\n" +
                "4. Uses potions when warmth gets low\n\n" +
                "⚠️ DISABLE 'Food Management' below when using potions!";
    }

    // Food Management Section
    @ConfigItem(
            keyName = "UseFoodManagement",
            name = "🍖 Enable Food Management",
            description = "Use regular food for healing. The bot will automatically withdraw food from bank when needed. Less efficient than potions but works without quest requirements.",
            position = 1,
            section = foodSection
    )
    default boolean useFoodManagement() {
        return true;
    }

    @ConfigItem(
            keyName = "Food",
            name = "Food Type",
            description = "Select the type of food to automatically withdraw from bank for healing (only applies to food management)",
            position = 2,
            section = foodSection
    )
    default Rs2Food food() {
        return Rs2Food.SALMON;
    }

    @ConfigItem(
            keyName = "Amount",
            name = "Food Amount",
            description = "Number of food items to automatically withdraw from bank per trip (applies to both healing methods)",
            position = 3,
            section = foodSection
    )
    default int foodAmount() {
        return 3;
    }

    @ConfigItem(
            keyName = "MinFood",
            name = "Minimum Food Threshold",
            description = "Bot will return to bank when food count drops below this number - safety buffer (applies to both healing methods)",
            position = 4,
            section = foodSection
    )
    default int minFood() {
        return 2;
    }

    @ConfigItem(
            keyName = "Eat at warmth level",
            name = "Eat at Warmth Level",
            description = "Consume food/potions when warmth drops to this level (applies to both healing methods)",
            position = 5,
            section = foodSection
    )
    default int eatAtWarmthLevel() {
        return 40;
    }

    @ConfigItem(
            keyName = "Warmth Tresshold",
            name = "Emergency Bank Warmth",
            description = "Emergency bank if warmth drops this low without food/potions (applies to both healing methods)",
            position = 6,
            section = foodSection
    )
    default int warmthTreshhold() {
        return 20;
    }

    @ConfigItem(
            keyName = "FoodLimitations",
            name = "📝 Food vs Potions Comparison",
            description = "Understanding the differences between food and potion healing methods",
            position = 7,
            section = foodSection
    )
    default String foodLimitations() {
        return "FOOD HEALING:\n" +
                "• Costs GP - bot withdraws from bank automatically\n" +
                "• Less warmth per item than potions\n" +
                "• Takes more inventory space\n" +
                "• Requires banking trips = less efficient\n" +
                "• Works immediately without quest requirements\n\n" +
                "POTION HEALING (Recommended):\n" +
                "• FREE - crafted from crate materials\n" +
                "• More warmth per use\n" +
                "• Less inventory space needed\n" +
                "• No banking required = more efficient\n" +
                "• Requires 'Druidic Ritual' quest\n\n" +
                "⚠️ DISABLE 'Rejuvenation Potions' above when using food!";
    }

    // Brazier Management
    @ConfigItem(
            keyName = "Brazier",
            name = "Preferred Brazier",
            description = "Which brazier to primarily use (affects positioning and efficiency)",
            position = 1,
            section = brazierSection
    )
    default Brazier brazierLocation() {
        return Brazier.SOUTH_EAST;
    }

    // Custom Break System
    @ConfigItem(
            keyName = "EnableCustomBreaks",
            name = "🛌 Enable Custom Break System",
            description = "Enable smart break management with both AFK and logout breaks for better anti-detection",
            position = 1,
            section = breakSection
    )
    default boolean enableCustomBreaks() {
        return true;
    }

    @ConfigItem(
            keyName = "MinBreakInterval",
            name = "Min Break Interval (minutes)",
            description = "Minimum time between breaks in minutes",
            position = 2,
            section = breakSection
    )
    default int minBreakInterval() {
        return 20;
    }

    @ConfigItem(
            keyName = "MaxBreakInterval",
            name = "Max Break Interval (minutes)",
            description = "Maximum time between breaks in minutes",
            position = 3,
            section = breakSection
    )
    default int maxBreakInterval() {
        return 140;
    }

    @ConfigItem(
            keyName = "LogoutBreakChance",
            name = "Logout Break Chance (%)",
            description = "Percentage chance for logout breaks vs AFK breaks (0-100%)",
            position = 4,
            section = breakSection
    )
    default int logoutBreakChance() {
        return 40;
    }

    @ConfigItem(
            keyName = "AfkBreakMinDuration",
            name = "AFK Break Min Duration (minutes)",
            description = "Minimum duration for AFK breaks (mouse offscreen)",
            position = 5,
            section = breakSection
    )
    default int afkBreakMinDuration() {
        return 2;
    }

    @ConfigItem(
            keyName = "AfkBreakMaxDuration",
            name = "AFK Break Max Duration (minutes)",
            description = "Maximum duration for AFK breaks (mouse offscreen)",
            position = 6,
            section = breakSection
    )
    default int afkBreakMaxDuration() {
        return 6;
    }

    @ConfigItem(
            keyName = "LogoutBreakMinDuration",
            name = "Logout Break Min Duration (minutes)",
            description = "Minimum duration for logout breaks",
            position = 7,
            section = breakSection
    )
    default int logoutBreakMinDuration() {
        return 5;
    }

    @ConfigItem(
            keyName = "LogoutBreakMaxDuration",
            name = "Logout Break Max Duration (minutes)",
            description = "Maximum duration for logout breaks",
            position = 8,
            section = breakSection
    )
    default int logoutBreakMaxDuration() {
        return 40;
    }

    @ConfigItem(
            keyName = "ForceBreakNow",
            name = "🚨 Force Break Now",
            description = "Immediately trigger a break when in a safe location",
            position = 9,
            section = breakSection
    )
    default boolean forceBreakNow() {
        return false;
    }

    @ConfigItem(
            keyName = "BreakSystemExplanation",
            name = "📖 How Break System Works",
            description = "Explanation of the custom break system",
            position = 10,
            section = breakSection
    )
    default String breakSystemExplanation() {
        return "🛌 CUSTOM BREAK SYSTEM:\n\n" +
                "AFK BREAKS (1-6 minutes):\n" +
                "• Moves mouse offscreen\n" +
                "• Appears as if you stepped away\n" +
                "• Character stays logged in\n" +
                "• Safer and more realistic\n\n" +
                "LOGOUT BREAKS (5-40 minutes):\n" +
                "• Logs out completely\n" +
                "• Longer break periods\n" +
                "• Simulates real break behavior\n" +
                "• Better for long-term safety\n\n" +
                "🎯 SMART TIMING:\n" +
                "• Only triggers in safe locations\n" +
                "• Waits for banking/waiting states\n" +
                "• Randomized intervals and durations\n" +
                "• Works independently of other break systems";
    }

    // Reward Cart Looting
    @ConfigItem(
            keyName = "EnableRewardCartLooting",
            name = "🏆 Enable Reward Cart Looting",
            description = "Automatically collect rewards from the Wintertodt reward cart when you have enough points",
            position = 1,
            section = rewardCartSection
    )
    default boolean enableRewardCartLooting() {
        return false;
    }

    @ConfigItem(
            keyName = "MinimumRewardsForCollection",
            name = "Minimum Rewards Threshold",
            description = "Minimum number of reward cart rewards required before collecting them (with random variance)",
            position = 2,
            section = rewardCartSection
    )
    default int minimumRewardsForCollection() {
        return 20;
    }

    @ConfigItem(
            keyName = "RewardsVariance",
            name = "Rewards Threshold Variance",
            description = "Random variance added/subtracted from minimum rewards (gaussian distribution)",
            position = 3,
            section = rewardCartSection
    )
    default int rewardsVariance() {
        return 10;
    }

    @ConfigItem(
            keyName = "RewardCartInfo",
            name = "📋 How Reward Cart Works",
            description = "Information about the reward cart looting system",
            position = 4,
            section = rewardCartSection
    )
    default String rewardCartInfo() {
        return "🏆 REWARD CART LOOTING:\n\n" +
                "WHEN IT TRIGGERS:\n" +
                "• When reward cart rewards ≥ (Minimum Rewards ± Random Variance)\n" +
                "• Tracks rewards from chat message: 'You're now owed X rewards'\n" +
                "• Only when in safe locations (not during activities)\n" +
                "• Automatically exits Wintertodt temporarily\n\n" +
                "WHAT IT DOES:\n" +
                "1. Exits Wintertodt area\n" +
                "2. Banks all items for clean inventory\n" +
                "3. Walks to reward cart (west of bank)\n" +
                "4. Uses 'Big-search' on reward cart\n" +
                "5. Collects all available rewards\n" +
                "6. Banks rewards, updates gear if received from reward cart, and returns to Wintertodt\n\n" +
                "🎯 SAFETY FEATURES:\n" +
                "• Only triggers during safe states\n" +
                "• Automatically detects when no more rewards\n" +
                "• Returns to normal script after completion\n" +
                "• Works with both food and potion healing methods\n\n";
    }

    // Advanced Options
    @ConfigItem(
            keyName = "HumanizedTiming",
            name = "Humanized Timing",
            description = "Add random delays and variations to actions for more human-like behavior",
            position = 1,
            section = advancedSection
    )
    default boolean humanizedTiming() {
        return true;
    }

    @ConfigItem(
            keyName = "MouseMovements",
            name = "Random Mouse Movements",
            description = "Occasionally move mouse randomly while idle for anti-detection",
            position = 2,
            section = advancedSection
    )
    default boolean randomMouseMovements() {
        return true;
    }

    @ConfigItem(
            keyName = "CameraMovementFrequency",
            name = "Random Camera Movement Frequency (seconds)",
            description = "Minimum time between random camera movements in seconds (0.1% chance per call, increases over time). Higher values = less frequent movements. Set to 0 to disable camera movements entirely.",
            position = 3,
            section = advancedSection
    )
    default int cameraMovementFrequency() {
        return 10;
    }

    @ConfigItem(
            keyName = "ShowAntibanOverlay",
            name = "Show Antiban Overlay",
            description = "Display antiban information in the overlay (action cooldowns, play style, etc.)",
            position = 4,
            section = advancedSection
    )
    default boolean showAntibanOverlay() {
        return true;
    }
}