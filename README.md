# SmallShips Addon

The official example addon for [Small Ships](https://modrinth.com/mod/rGWEHQrP). It adds four ships — **Early Cog**, **Early Caravel**, **Rowing Boat** and **Fishing Boat** — using only the Small Ships API, with no changes to the main mod.

The project is also meant as a **template**: copy it, rename it, swap the ships for your own and you have a working Small Ships addon for Fabric and NeoForge (or Forge on 1.20.1).

| Branch   | Minecraft | Loaders            | Java | Needs Small Ships |
|----------|-----------|--------------------|------|-------------------|
| `1.21.1` | 1.21.1    | Fabric, NeoForge   | 21   | >= 2.0.2          |
| `1.20.1` | 1.20.1    | Fabric, Forge      | 17   | >= 2.0.1          |

Each Minecraft version has its own branch, named after that version. Pick the branch for the version you are targeting before you start.

---

## Quick start

### 1. Requirements

- **JDK 21** for the `1.21.1` branch (JDK 17 for `1.20.1`)
- **IntelliJ IDEA** (recommended) or any IDE with Gradle support
- Git

You don't need to install Gradle yourself; the wrapper (`gradlew`) downloads the right version (8.8).

### 2. Clone and pick the branch

```bash
git clone https://github.com/talhanation/smallships_addon.git
cd smallships_addon
git checkout 1.21.1
```

### 3. Open the project

Open the project folder in IntelliJ as a **Gradle project** and let it sync. The first sync downloads Minecraft, the loaders and Small Ships, so it takes a few minutes.

Small Ships is pulled from the **Modrinth Maven**. You don't need a local copy of the main mod.

### 4. Start the game

After the sync, Architectury Loom generates run configurations for each loader (`Minecraft Client (:fabric)`, `Minecraft Client (:neoforge)` and the server variants). You can also start from the terminal:

```bash
./gradlew :fabric:runClient
./gradlew :neoforge:runClient
```

In-game, place a Small Ships **dockyard**. The addon ships appear in its list, and the ship items appear in the Small Ships creative tab.

### 5. Build the jars

```bash
./gradlew build
```

The release jars are written to:

```
fabric/build/libs/smallships_addon-<version>-fabric-<mc_version>.jar
neoforge/build/libs/smallships_addon-<version>-neoforge-<mc_version>.jar
```

Only upload these. The `-dev`, `-dev-shadow` and `-sources` jars are build by-products.

---

## Using this as a template

To make your own addon from this project, rename everything that carries the id `smallships_addon`. A full-text search for `smallships_addon` finds almost all of it.

**Gradle**
- `settings.gradle` → `rootProject.name`
- `gradle.properties` → `archives_base_name`, `maven_group`, `mod_version`

**Code**
- `SmallShipsAddonMod.MOD_ID`
- The package `com.talhanation.smallships_addon` in `common`, `fabric` and `neoforge`. Use your IDE's refactoring so the `...fabric` / `...neoforge` sub-packages move along too (see [Platform code](#platform-code-expectplatform)).
- `update/UpdateChecker.java` → `UPDATE_URL` and `DEFAULT_HOMEPAGE` must point to **your** repository, or your players get update messages for this addon. Also rename the "Small Ships Addon" log texts and the thread name there and in `client/UpdateNotifier.java`.

**Metadata**
- `fabric/src/main/resources/fabric.mod.json` → `id`, `name`, `description`, `entrypoints`
- `neoforge/src/main/resources/META-INF/neoforge.mods.toml` → `modId`, `displayName`, `description`, and the `[[dependencies.<modid>]]` headers
- `update.json` → `version`, `homepage`
- `icon.png` in both loader modules

**Resources**
- Rename the folders `assets/smallships_addon/` and `data/smallships_addon/` to your mod id.
- Rename `smallships_addon.accesswidener`, and update the path in `common/build.gradle` (`accessWidenerPath`) and in `neoforge/build.gradle` (`atAccessWideners`).
- Change the lang keys in `en_us.json` (`entity.<modid>.…`, `item.<modid>.…`, `chat.<modid>.…`).

You don't need to rename the config keys. They are built from `MOD_ID` (`<modid>ShipAttributeEarlyCog`, …).

---

## Architecture

### Modules

The project is an **Architectury** multiloader setup with three Gradle subprojects:

```
smallships_addon/
├── common/     all game logic: ships, config, packets, models, renderers, update check
├── fabric/     Fabric entry points + Fabric side of the @ExpectPlatform methods
├── neoforge/   NeoForge entry points + NeoForge side of the @ExpectPlatform methods
│               (forge/ on the 1.20.1 branch)
├── build.gradle        shared setup for all subprojects (Loom, Mojang mappings, Java version, repos)
├── settings.gradle     plugin repositories and the module list
├── gradle.properties   versions of Minecraft, loaders, Small Ships and libraries
└── update.json         version info read by the update checker
```

Almost everything is written once in `common`. The loader modules only contain what differs between loaders: entry points, registries, event hooks and networking.

| Tool | Version (`1.21.1`) |
|---|---|
| Architectury Plugin | 3.4.164 |
| Architectury Loom | 1.7.435 |
| Shadow | 8.1.1 |
| Gradle | 8.8 |
| Fabric Loader / Fabric API | 0.16.0 / 0.102.0+1.21.1 |
| NeoForge | 21.1.4 |
| Forge Config API Port | 21.1.0 |
| Mappings | Official Mojang mappings |

The addon does **not** depend on the Architectury API at runtime. Only the Gradle plugin and Loom are used. `@ExpectPlatform` is resolved at build time.

### How the jars are built

- `common` compiles against Small Ships and is transformed per loader (`transformProductionFabric`, `transformProductionNeoForge`).
- Each loader module **shadows** the transformed `common` output into its own jar (`shadowCommon` configuration) and remaps it (`remapJar`). That gives one self-contained jar per loader.
- The access widener lives in `common`. Fabric injects it into the jar (`injectAccessWidener = true`); NeoForge converts it to an access transformer (`atAccessWideners`).

### Small Ships dependency

Small Ships comes from the Modrinth Maven, with one version id per loader in `gradle.properties`:

```properties
smallships_modrinth_id=rGWEHQrP
smallships_fabric_version=vJnFZ5fQ
smallships_neoforge_version=2iLK0Wz6
```

There is no common jar of Small Ships, so `common` compiles against the **Fabric** jar (`modCompileOnly`), which contains the common classes too. Each loader module then brings its own jar at runtime.

**To move to a newer Small Ships version:**
1. On the Modrinth page of Small Ships, open the version you want for each loader and copy its **version id**.
2. Put the ids into `smallships_fabric_version` / `smallships_neoforge_version`.
3. Raise the minimum version in `fabric.mod.json` (`"smallships": ">=x.y.z"`) and `neoforge.mods.toml` (`versionRange = "[x.y.z,)"`).

### Platform code (`@ExpectPlatform`)

Where a method has to work differently per loader, `common` declares it with `@ExpectPlatform` and the loader modules provide the implementation. The name has to match exactly, or the build fails:

```
<package>.<Class>               →  <package>.fabric.<Class>Impl
                                →  <package>.neoforge.<Class>Impl
```

Used in this addon:

| Common class | What the loader provides |
|---|---|
| `world/entity/AddonEntityTypes` | Entity type registration (`DeferredRegister` on NeoForge, `Registry.register` on Fabric) |
| `network/AddonPackets` | Payload registration and sending |
| `update/UpdateChecker` | The installed mod version, read from the loader |

### Load order

The order matters, because Small Ships reads configs while registering ships:

1. **Config spec**: `AddonConfig.register()` in the `SmallShipsAddonMod` constructor. NeoForge only accepts config specs while a mod is being constructed.
2. **Ship items**: `AddonItems.register()`. On NeoForge this has to happen in the **mod constructor**, because NeoForge stops accepting items afterwards.
3. **Packets, entity types, ship types**: `SmallShipsAddonMod.init()`, which runs **after** the configs are loaded:
   - NeoForge / Forge: in `FMLCommonSetupEvent#enqueueWork`. Mods are constructed in parallel, so the configs aren't there yet in the constructor, and registering a ship type there would read default values.
   - Fabric: directly in `onInitialize`. Configs are already loaded by then.
4. **Client**: model layers and entity renderers are registered in the loader modules (`ClientModBus` on NeoForge, `SmallShipsAddonFabricClient` on Fabric). Sail and banner models are registered in `client/AddonClientInitializer`.

### Hooks into Small Ships

An addon talks to the main mod in only a few places:

| What | Where in this addon | Small Ships API |
|---|---|---|
| Ship type + fallback recipe for the dockyard | `world/entity/ship/AddonShipTypes` | `ShipRegistry.register(ShipType.builder(...))` |
| Ship items (one per wood type, in the Small Ships creative tab) | `world/item/AddonItems` | `ShipItems.register(modId, id, factory)` |
| Ship attributes, synced from the server | `config/AddonConfig` | `SmallShipsConfig.defineAttributes(...)` |
| Config registration | `config/AddonConfig#register` | `SmallShipsConfig.registerConfigs(...)` |
| Sail, sail banner, mast banner | `client/AddonClientInitializer` | `ShipRenderRegistry.registerSail / registerSailBanner / registerMastBanner` |
| Rendering hull, sail, damage, cannons | `client/renderer/entity/*Renderer` | extend `ShipRenderer` |
| Ship behaviour | `world/entity/ship/*Entity` | extend `Ship` / `ContainerShip`, implement abilities (`Sailable`, `Seatable`, `Paddleable`, `Shieldable`, `Bannerable`, …) |
| Packets | `network/AddonPackets` | implement `ModPacket` (a `TYPE` and a `CODEC`) |

**Ship attributes:** they must be defined through `SmallShipsConfig.defineAttributes`. Only then are they part of the snapshot the server sends to joining clients. A hand-built `ShipAttributes` would make the client read its **local** config on a server.

**Dockyard recipes:** the recipe that is actually used comes from `data/<modid>/dockyard_recipes/<ship_id>.json`, which data packs can override. The recipe in `AddonShipTypes` is only the fallback. Keep the two in sync.

```json
{
  "build_time": 1600,
  "ingredients": [
    { "tag": "minecraft:planks", "count": 64 },
    { "item": "minecraft:white_wool", "count": 16 }
  ]
}
```

**Packets:** the addon registers its packets under its **own** mod id and not through Small Ships' `ModPackets`. NeoForge hands each mod its own payload registrar.

---

## Adding a new ship

Use one of the existing ships as a model (the Early Cog has sail, banners and shields; the Rowing Boat is the minimal case with oars only).

1. **Entity**: `world/entity/ship/MyShipEntity.java`. Extend `ContainerShip`, give it a `public static final String ID`, a `summon(...)` factory, hitbox parts (`getParts()`), seats (`getSeats()`) and a wind profile.
2. **Entity type**: add a field in `AddonEntityTypes` and register it in **both** `fabric/.../AddonEntityTypesImpl` and `neoforge/.../AddonEntityTypesImpl`.
3. **Config**: add an attribute block (with `defineAttributes`), container size and biome type in `AddonConfig`.
4. **Ship type**: `ShipRegistry.register(...)` in `AddonShipTypes`.
5. **Items**: one line `ShipItems.register(...)` in `AddonItems`.
6. **Recipe**: `data/<modid>/dockyard_recipes/<id>.json`.
7. **Client**: model + renderer in `client/`, then register the model layer and the renderer in **both** loader modules. A missing layer crashes the game on startup. Register sail/banner models in `AddonClientInitializer`.
8. **Assets**:
   - Item models `assets/<modid>/models/item/<wood>_<id>.json` and textures for every wood type: oak, spruce, birch, jungle, acacia, dark_oak, mangrove, cherry, bamboo, crimson, warped
   - Lang entries `entity.<modid>.<id>` and `item.<modid>.<wood>_<id>`

Entity ids must be unique. On NeoForge/Forge a duplicate registry name is a hard crash.

---

## Update checker

The addon has its own update checker. It works the same on every loader and doesn't use the Forge update system.

- Each **branch** has its own `update.json` in its root. A build only reads the file of the branch that matches the Minecraft version it runs on:
  `https://raw.githubusercontent.com/<owner>/<repo>/<mc_version>/update.json`
- To announce a release, raise `version` in the `update.json` of that branch. Only players on that Minecraft version are notified.

```json
{
  "version": "1.0.0",
  "homepage": "https://modrinth.com/project/small-ships-addon"
}
```

- The check runs once per game start on a background thread. The server logs the result; the client shows a chat message when joining a world.
- Both can be turned off in the config (`updateCheckerEnable` on the server, `clientUpdateCheckerEnable` on the client).

**Versioning:** a bugfix raises the third digit (`1.0.0` → `1.0.1`), a new feature raises the second (`1.0.0` → `1.1.0`).

---

## Troubleshooting

- **The ship reads default config values / wrong container size**: the ship type was registered before the configs were loaded. On NeoForge/Forge, `SmallShipsAddonMod.init()` has to run inside `FMLCommonSetupEvent#enqueueWork`.
- **Ship items missing or a registry error on NeoForge**: `AddonItems.register()` was called too late. It belongs in the mod constructor.
- **`AbstractMethodError` or strange missing-method errors after changing the Small Ships version**: Loom still has the old remapped jar. Delete `.gradle/loom-cache/remapped_mods`, then reload Gradle.
- **Crash on startup in the renderer**: the model layer is not registered in one of the loader modules.

---

## License

All Rights Reserved.
