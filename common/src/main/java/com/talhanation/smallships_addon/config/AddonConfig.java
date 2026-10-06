package com.talhanation.smallships_addon.config;

import com.talhanation.smallships.config.SmallShipsConfig;
import com.talhanation.smallships.world.entity.ship.Ship;
import com.talhanation.smallships_addon.SmallShipsAddonMod;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The addons' own server and client config.
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
 *
 * The client spec only holds what is the players' own choice: whether the
 * update check tells him in chat that a new version is out.
 */
public class AddonConfig {

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final ForgeConfigSpec CLIENT_SPEC;

    public static SmallShipsConfig.ShipAttributes earlyCogAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> earlyCogContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> earlyCogBiome;

    public static SmallShipsConfig.ShipAttributes earlyCaravelAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> earlyCaravelContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> earlyCaravelBiome;

    public static SmallShipsConfig.ShipAttributes rowingBoatAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> rowingBoatContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> rowingBoatBiome;

    public static SmallShipsConfig.ShipAttributes fishingBoatAttributes;
    public static ForgeConfigSpec.ConfigValue<Integer> fishingBoatContainerSize;
    public static ForgeConfigSpec.EnumValue<Ship.BiomeModifierType> fishingBoatBiome;
    public static ForgeConfigSpec.IntValue fishingBoatNetCatchTime;
    public static ForgeConfigSpec.IntValue fishingBoatNetTowBonus;
    public static ForgeConfigSpec.DoubleValue fishingBoatNetMaxFishSize;
    public static ForgeConfigSpec.ConfigValue<List<String>> fishingBoatNetCrewEntities;

    public static ForgeConfigSpec.BooleanValue updateCheckerEnable;
    public static ForgeConfigSpec.BooleanValue clientUpdateCheckerEnable;

    static {
        ForgeConfigSpec.Builder serverConfigBuilder = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder clientConfigBuilder = new ForgeConfigSpec.Builder();
        setupServerConfig(serverConfigBuilder);
        setupClientConfig(clientConfigBuilder);
        SERVER_SPEC = serverConfigBuilder.build();
        CLIENT_SPEC = clientConfigBuilder.build();
    }

    private static void setupServerConfig(ForgeConfigSpec.Builder builder) {
        ArrayList<String> FISHING_BOAT_NET_CREW_ENTITIES = new ArrayList<>(
                Arrays.asList("workers:fisherman"));

        builder.push("Ship");

        //////////////////////////////////////EARLY_COG///////////////////////////////////////////
        builder.push("EarlyCog");

        builder.comment("Default attributes for the Early Cog. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        // maxHealth, maxSpeed, maxReverseSpeed, maxRotationSpeed, acceleration, rotationAcceleration
        earlyCogAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddonMod.MOD_ID + "ShipAttributeEarlyCog",
                150.0D, 24.0D, 0.1D, 3.5D, 0.010D, 0.750D);

        builder.pop();

        builder.comment("Default configs for the container of the Early Cog.");
        builder.push("Container");

        builder.comment("Set container size for the Early Cog (value must be divisible by 9 and bigger than 0).");
        earlyCogContainerSize = builder
                .define("earlyCogContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Early Cog specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Early Cog. Can be NONE, COLD, NEUTRAL, or WARM");
        earlyCogBiome = builder
                .defineEnum("earlyCogBiome", Ship.BiomeModifierType.COLD);

        builder.pop();
        builder.pop();

        //////////////////////////////////////EARLY_CARAVEL///////////////////////////////////////////
        builder.push("EarlyCaravel");

        builder.comment("Default attributes for the Early Caravel. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        earlyCaravelAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddonMod.MOD_ID + "ShipAttributeEarlyCaravel",
                150.0D, 23.0D, 0.1D, 3.8D, 0.010D, 0.750D);

        builder.pop();

        builder.comment("Default configs for the container of the Early Caravel.");
        builder.push("Container");

        builder.comment("Set container size for the Early Caravel (value must be divisible by 9 and bigger than 0).");
        earlyCaravelContainerSize = builder
                .define("earlyCaravelContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Early Caravel specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Early Caravel. Can be NONE, COLD, NEUTRAL, or WARM");
        earlyCaravelBiome = builder
                .defineEnum("earlyCaravelBiome", Ship.BiomeModifierType.WARM);

        builder.pop();
        builder.pop();


        //////////////////////////////////////ROWING_BOAT///////////////////////////////////////////
        builder.push("RowingBoat");

        builder.comment("Default attributes for the Rowing Boat. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        rowingBoatAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddonMod.MOD_ID + "ShipAttributeRowingBoat",
                50.0D, 15.0D, 0.1D, 10.0D, 0.010D, 1.00D);

        builder.pop();

        builder.comment("Default configs for the container of the Rowing Boat.");
        builder.push("Container");

        builder.comment("Set container size for the Rowing Boat (value must be divisible by 9 and bigger than 0).");
        rowingBoatContainerSize = builder
                .define("rowingBoatContainerSize", 27, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Rowing Boat specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Rowing Boat. Can be NONE, COLD, NEUTRAL, or WARM");
        rowingBoatBiome = builder
                .defineEnum("rowingBoatBiome", Ship.BiomeModifierType.NONE);

        builder.pop();
        builder.pop();

        //////////////////////////////////////FISHING_BOAT///////////////////////////////////////////
        builder.push("FishingBoat");

        builder.comment("Default attributes for the Fishing Boat. Speed in km/h, Health in default mc health points");
        builder.push("Attributes");

        fishingBoatAttributes = SmallShipsConfig.defineAttributes(builder, SmallShipsAddonMod.MOD_ID + "ShipAttributeFishingBoat",
                140.0D, 21.0D, 0.1D, 3.6D, 0.009D, 0.700D);

        builder.pop();

        builder.comment("Default configs for the container of the Fishing Boat.");
        builder.push("Container");

        builder.comment("Set container size for the Fishing Boat (value must be divisible by 9 and bigger than 0).");
        fishingBoatContainerSize = builder
                .define("fishingBoatContainerSize", 54, e -> e instanceof Integer i && i % 9 == 0 && i > 0);

        builder.pop();

        builder.comment("Fishing Boat specific speed modifiers.");
        builder.push("Modifier");

        builder.comment("Specify biome type for the Fishing Boat. Can be NONE, COLD, NEUTRAL, or WARM");
        fishingBoatBiome = builder
                .defineEnum("fishingBoatBiome", Ship.BiomeModifierType.NONE);

        builder.pop();

        builder.comment("Configs for the net of the Fishing Boat.");
        builder.push("Net");

        builder.comment("Seconds the lowered net needs to bring up a catch by itself.");
        fishingBoatNetCatchTime = builder
                .defineInRange("fishingBoatNetCatchTime", 30, 1, 3600);

        builder.comment("Seconds taken off the wait for the next catch each time the net has been towed on. Checked every 3 seconds, 0 turns the bonus off.");
        fishingBoatNetTowBonus = builder
                .defineInRange("fishingBoatNetTowBonus", 1, 0, 60);

        builder.comment("Biggest hitbox, width and height in blocks, a water animal may have to be caught and killed by the net. 0.8 takes fish and squids and lets dolphins through.");
        fishingBoatNetMaxFishSize = builder
                .defineInRange("fishingBoatNetMaxFishSize", 0.8D, 0.0D, 16.0D);

        builder.comment("Non player entities that keep the net out while they are aboard, for example: [\"workers:fisherman\", ...]. With neither a player nor one of these in the boat the net is hauled in.");
        fishingBoatNetCrewEntities = builder
                .define("fishingBoatNetCrewEntities", FISHING_BOAT_NET_CREW_ENTITIES);

        builder.pop();
        builder.pop();

        ////

        builder.pop();

        builder.comment(" This category holds configs that define general mod settings.");
        builder.push("General");

        builder.comment("Check for a new version of the addon when the server starts and write the result to the server log.");
        updateCheckerEnable = builder
                .define("updateCheckerEnable", true);

        builder.pop();
    }

    private static void setupClientConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(" This category holds configs that define general mod settings.");
        builder.push("General");

        builder.comment("Check for a new version of the addon and show a chat message when joining a world while an update is available.");
        clientUpdateCheckerEnable = builder
                .define("updateCheckerEnable", true);

        builder.pop();
    }

    /** Registers the specs. Must run before anything reads a value from them. */
    public static void register() {
        SmallShipsConfig.registerConfigs(SmallShipsAddonMod.MOD_ID, SmallShipsConfig.ModConfigWrapper.Type.SERVER, SERVER_SPEC);
        SmallShipsConfig.registerConfigs(SmallShipsAddonMod.MOD_ID, SmallShipsConfig.ModConfigWrapper.Type.CLIENT, CLIENT_SPEC);
    }
}
