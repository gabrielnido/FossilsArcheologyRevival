package com.github.revival;

import com.github.revival.client.renderer.tileentity.FeederRenderer;
import com.github.revival.server.ModState;
import com.github.revival.server.ServerProxy;
import com.github.revival.server.biome.BasicBiome;
import com.github.revival.server.block.FABlockRegistry;
import com.github.revival.server.block.entity.*;
import com.github.revival.server.block.sound.FossilSoundType;
import com.github.revival.server.config.FossilConfig;
import com.github.revival.server.creativetab.FATabRegistry;
import com.github.revival.server.dimension.anu.AnuWorldProvider;
import com.github.revival.server.dimension.treasure.TreasureWorldProvider;
import com.github.revival.server.enchantment.ArcheologyEnchantment;
import com.github.revival.server.enchantment.PaleontologyEnchantment;
import com.github.revival.server.entity.*;
import com.github.revival.server.entity.mob.*;
import com.github.revival.server.enums.EnumDinoFoodMob;
import com.github.revival.server.enums.EnumPrehistoric;
import com.github.revival.server.gen.*;
import com.github.revival.server.gen.structure.AcademyGenerator;
import com.github.revival.server.gen.structure.ShipWreckGenerator;
import com.github.revival.server.handler.*;
import com.github.revival.server.item.FAItemRegistry;
import com.github.revival.server.util.FossilFoodMappings;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.ilexiconn.llibrary.common.config.ConfigHelper;
import net.ilexiconn.llibrary.common.content.ContentHelper;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import org.apache.logging.log4j.Level;

@Mod(modid = Revival.MODID, name = "Fossils and Archeology Revival", version = Revival.VERSION, dependencies = "required-after:llibrary@[" + Revival.LLIBRARY_VERSION + ",)")
public class Revival {
    public static final String MODID = "fossil";
    public static final ModState STATE = ModState.DEV;
    public static final String VERSION = "7.3.0-develop";
    public static final String LLIBRARY_VERSION = "0.7.0";
    public static final FossilSoundType soundTypeSlime = new FossilSoundType(1.0F, 1.0F);
    @SidedProxy(clientSide = "com.github.revival.client.ClientProxy", serverSide = "com.github.revival.server.ServerProxy")
    public static ServerProxy proxy;
    @Instance(MODID)
    public static Revival instance;
    public static FossilGuiHandler guiHandler = new FossilGuiHandler();
    public static Object toPedia;
    public static int feederRenderID;
    public static Enchantment paleontology;
    public static Enchantment archeology;
    public static BiomeGenBase anuBiome;
    public static BiomeGenBase treasureBiome;
    public static ArmorMaterial bone = EnumHelper.addArmorMaterial("Bone", 25, new int[]{2, 7, 6, 2}, 15);
    public static ToolMaterial scarab = EnumHelper.addToolMaterial("Scarab", 3, 1861, 8.0F, 4.0F, 25);
    public static ToolMaterial toothDaggerMaterial = EnumHelper.addToolMaterial("toothDagger", 3, 250, 70.0F, 1.5F, 25);
    public static Material tar_material;
    public static Fluid tar_fluid;
    public Configuration config;

    public static boolean enableDebugging() {
        return STATE == ModState.DEV;
    }

    public static void showMessage(String message, EntityPlayer player) {
        if (player != null) {
            player.addChatMessage(new ChatComponentText(message));
        }
    }

    public static void printDebug(String message) {
        if (enableDebugging()) {
            FMLLog.log(Revival.MODID, Level.INFO, message);
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new FossilBonemealEvent());
        MinecraftForge.EVENT_BUS.register(new EventPlayer());
        VillagerRegistry.instance().registerVillageTradeHandler(10, new FossilTradeHandler());
        VillagerRegistry.instance().registerVillagerId(10);

        ConfigHelper.registerConfigHandler(MODID, event.getSuggestedConfigurationFile(), new FossilConfig());
        ContentHelper.init(new FATabRegistry(), new FABlockRegistry(), new FAItemRegistry());
        EnumPrehistoric.init();
        FossilOreDictionary.oreRegistration();
        FossilFoodMappings.init();
        DimensionManager.registerProviderType(FossilConfig.dimIdDarknessLair, AnuWorldProvider.class, false);
        DimensionManager.registerDimension(FossilConfig.dimIdDarknessLair, FossilConfig.dimIdDarknessLair);
        DimensionManager.registerProviderType(FossilConfig.dimIdTreasure, TreasureWorldProvider.class, false);
        DimensionManager.registerDimension(FossilConfig.dimIdTreasure, FossilConfig.dimIdTreasure);

        paleontology = new PaleontologyEnchantment(FossilConfig.enchIdPaleontology, 2, EnumEnchantmentType.digger);
        archeology = new ArcheologyEnchantment(FossilConfig.enchIdArcheology, 2, EnumEnchantmentType.digger);

        anuBiome = new BasicBiome(FossilConfig.biomeIdDarknessLair, Blocks.netherrack, Blocks.netherrack, true, 0, 0).setDisableRain().setBiomeName(LocalizationStrings.BIOME_ANU).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));
        treasureBiome = new BasicBiome(FossilConfig.biomeIdTreasure, Blocks.air, Blocks.air, true, 1, 0).setDisableRain().setBiomeName(StatCollector.translateToLocal("biome.treasure.name")).setTemperatureRainfall(0.8F, 0F).setHeight(new BiomeGenBase.Height(0F, 0F));

        EntityRegistry.registerModEntity(StoneboardEntity.class, "StoneBoard", 1, this, 250, Integer.MAX_VALUE, false);
        EntityRegistry.registerModEntity(JavelinEntity.class, "Javelin", 2, this, 250, 5, true);
        EntityRegistry.registerModEntity(AncientJavelinEntity.class, "AncientJavelin", 3, this, 250, 5, true);
        EntityRegistry.registerModEntity(MLightingEntity.class, "FriendlyLighting", 4, this, 250, 5, true);
        EntityRegistry.registerModEntity(FailuresaurusEntity.class, "Failuresaurus", 5, this, 250, 3, true);
        EntityRegistry.registerModEntity(BonesEntity.class, "Bones", 6, this, 250, 3, true);
        EntityRegistry.registerModEntity(DinoEggEntity.class, "DinoEgg", 8, this, 250, 5, true);
        EntityRegistry.registerModEntity(FriendlyPigZombieEntity.class, "FriendlyPigZombie", 12, this, 250, 3, true);
        EntityRegistry.registerModEntity(AnuEntity.class, "PigBoss", 13, this, 250, 3, true);
        EntityRegistry.registerModEntity(SmilodonEntity.class, "Smilodon", 22, this, 250, 3, true);
        EntityRegistry.registerModEntity(MammothEntity.class, "Mammoth", 24, this, 250, 3, true);
        EntityRegistry.registerModEntity(DodoEntity.class, "Dodo", 25, this, 250, 3, true);
        EntityRegistry.registerModEntity(DodoEggEntity.class, "DodoEgg", 26, this, 250, 5, true);
        EntityRegistry.registerModEntity(CoelacanthEntity.class, "Coelacanth", 28, this, 250, 5, true);
        EntityRegistry.registerModEntity(QuaggaEntity.class, "Quagga", 30, this, 250, 3, true);
        EntityRegistry.registerModEntity(TerrorBirdEntity.class, "TerrorBird", 31, this, 250, 3, true);
        EntityRegistry.registerModEntity(TerrorBirdEggEntity.class, "TerrorBirdEgg", 32, this, 250, 5, true);
        EntityRegistry.registerModEntity(ElasmotheriumEntity.class, "Elasmotherium", 33, this, 250, 3, true);
        EntityRegistry.registerModEntity(AnuEffectEntity.class, "AnuEffect", 34, this, 250, 5, true);
        EntityRegistry.registerModEntity(AnubiteEntity.class, "Anubite", 39, this, 250, 3, true);
        EntityRegistry.registerModEntity(SentryPigmanEntity.class, "SentryPigman", 40, this, 250, 3, true);
        EntityRegistry.registerModEntity(AnuDeadEntity.class, "AnuDead", 41, this, 250, 3, true);
        EntityRegistry.registerModEntity(TarSlimeEntity.class, "TarSlime", 42, this, 250, 3, true);

        for (int i = 0; i < EnumPrehistoric.values().length; i++) {
            EntityRegistry.registerModEntity(EnumPrehistoric.values()[i].getDinoClass(), EnumPrehistoric.values()[i].name(), 200 + i, this, 250, 3, true);
        }

        EntityRegistry.addSpawn(CoelacanthEntity.class, 1, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
        EntityRegistry.addSpawn(NautilusEntity.class, 5, 4, 14, EnumCreatureType.waterCreature, BiomeGenBase.river, BiomeGenBase.ocean);

        FossilSpawnEggs.addSpawnEggs();
        EnumDinoFoodMob.init();

        GameRegistry.registerWorldGenerator(new FossilGenerator(), 0);

        if (FossilConfig.generatePalaeoraphe) {
            GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe(), 0);
        }
        if (FossilConfig.generateAcademy) {
            GameRegistry.registerWorldGenerator(new AcademyGenerator(), 0);
        }
        if (FossilConfig.generateShips) {
            GameRegistry.registerWorldGenerator(new ShipWreckGenerator(), 0);
        }

        GameRegistry.registerWorldGenerator(new WorldGenMiscStructures(), 0);

        GameRegistry.registerWorldGenerator(new TarGenerator(), 0);
        GameRegistry.registerWorldGenerator(new VolcanicRockGenerator(), 13);

        feederRenderID = RenderingRegistry.getNextAvailableRenderId();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);

        GameRegistry.registerTileEntity(CultivateTile.class, LocalizationStrings.BLOCK_CULTIVATE_IDLE_NAME);
        GameRegistry.registerTileEntity(AnalyzerTile.class, LocalizationStrings.BLOCK_ANALYZER_IDLE_NAME);
        GameRegistry.registerTileEntity(WorktableTile.class, LocalizationStrings.BLOCK_WORKTABLE_IDLE_NAME);
        GameRegistry.registerTileEntity(DrumTile.class, LocalizationStrings.DRUM_NAME);
        GameRegistry.registerTileEntity(FeederTile.class, LocalizationStrings.T_FEEDER_IDLE_NAME);
        GameRegistry.registerTileEntity(TimeMachineTile.class, LocalizationStrings.BLOCK_TIMEMACHINE_NAME);
        GameRegistry.registerTileEntity(SifterTile.class, LocalizationStrings.BLOCK_SIFTER_IDLE);
        GameRegistry.registerTileEntity(FigurineTile.class, "figurineType");
        GameRegistry.registerTileEntity(VaseTile.class, "vaseType");
        GameRegistry.registerTileEntity(AnuTotemTile.class, LocalizationStrings.BLOCK_ANU_NAME);
        GameRegistry.registerTileEntity(AnubiteStatueTile.class, "Anubite_Statue");
        GameRegistry.registerTileEntity(AncientChestTile.class, "Ancient_Chest");
        GameRegistry.registerTileEntity(SarcophagusTile.class, "sarcophagus");

        RenderingRegistry.registerBlockHandler(2303, FeederRenderer.INSTANCE);
        proxy.init();

        FossilRecipeHandler.addRecipe();

        FMLCommonHandler.instance().bus().register(new PickupHandler());
        FMLCommonHandler.instance().bus().register(new EventFossilAchivements());

        proxy.registerChestLoot();
        FossilAchievementHandler.loadAchievements();
        MinecraftForge.EVENT_BUS.register(new FossilToolEvent());
        MinecraftForge.EVENT_BUS.register(new FossilLivingEvent());
        MinecraftForge.EVENT_BUS.register(new FossilInteractEvent());

        FMLCommonHandler.instance().bus().register(new FossilConnectionEvent());

    }
}
