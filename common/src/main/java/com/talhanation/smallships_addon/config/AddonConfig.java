package com.talhanation.smallshipsaddon.config;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallshipsaddon.SmallShipsAddon;
import net.minecraftforge.common.ForgeConfigSpec;

/**
 * The addons' own server config.
 *
 * An addon can NOT write into the main mods' config spec, so it builds its own
 * and defines its ship attributes on it through
 * {@link SmallShipsConfig#defineAttributes}. That call is what puts the block
 * into the main mods' attribute registry, and from there into the snapshot the
 * server sends a joining client. Skip it and build a ShipAttributes by hand and
 * the ship would read the CLIENTS local file while connected to a server -
 * different numbers in the stat panel, different prediction in the renderer.
 *
 * The prefix carries the mod id so it can never collide with another mods' key.
 * Type SERVER, because ship attributes are world rules, not client taste.
 */
public class AddonConfig {

    public static final ForgeConfigSpec SERVER_SPEC;

    public static SmallShipsConfig.ShipAttributes crayerAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> crayerContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> crayerBiome;

    public static SmallShipsConfig.ShipAttributes saettiaAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> saettiaContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> saettiaBiome;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        setupServerConfig(builder);
        SERVER_SPEC = builder.build();
    }

    private static void setupServerConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Ship");

        //////////////////////////////////////CRAYER///////////////////////////////////////////
        builder.push("Crayer");

        builder.comment("Default attributes for the Crayer. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        // weaker than the Cog (400 hp, 27 km/h, 4.0 rot, 0.010 acc, 0.750 rotAcc)
        // in every single value - this is the hull a player outgrows
        crayerAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddon.MOD_ID + "ShipAttributeCrayer",
                150.0D, 22.0D, 0.08D, 3.5D, 0.008D, 0.650D);

        builder.pop();

        builder.comment("Default configs for the container of the Crayer.");
        builder.push("Container");

        // 54 and not 56: a container is rows of nine, and the validator below
        // would reject 56 and silently leave the default in place
        builder.comment("Set container size for the Crayer (value must be divisible by 9 and bigger than 0).");
        crayerContainerSize = builder
                .define("crayerContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Crayer specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Crayer. Can be NONE, COLD, NEUTRAL, or WARM");
        crayerBiome = builder
                .defineEnum("crayerBiome", Ship.BiomeModifierType.NONE);

        builder.pop();
        builder.pop();

        //////////////////////////////////////SAETTIA///////////////////////////////////////////
        builder.push("Saettia");

        builder.comment("Default attributes for the Saettia. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        // the same hull strength as the Crayer, spent differently: the lateen
        // yard pivots, so she turns better, but the big sail is slow to fill
        saettiaAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddon.MOD_ID + "ShipAttributeSaettia",
                150.0D, 23.0D, 0.08D, 3.8D, 0.007D, 0.700D);

        builder.pop();

        builder.comment("Default configs for the container of the Saettia.");
        builder.push("Container");

        builder.comment("Set container size for the Saettia (value must be divisible by 9 and bigger than 0).");
        saettiaContainerSize = builder
                .define("saettiaContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Saettia specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Saettia. Can be NONE, COLD, NEUTRAL, or WARM");
        saettiaBiome = builder
                .defineEnum("saettiaBiome", Ship.BiomeModifierType.WARM);

        builder.pop();
        builder.pop();

        builder.pop();
    }

    /** Registers the spec. Must run before anything reads a value from it. */
    public static void register() {
        SmallShipsConfig.registerConfigs(SmallShipsAddon.MOD_ID, SmallShipsConfig.ModConfigWrapper.Type.SERVER, SERVER_SPEC);
    }
}
