package com.slomaxonical.architectspalette;

import com.slomaxonical.architectspalette.compat.cloth_config.ApConfigs;
import com.slomaxonical.architectspalette.crafting.WarpingRecipe;
import com.slomaxonical.architectspalette.loot.LootTableModifications;
import com.slomaxonical.architectspalette.registry.*;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArchitectsPalette implements ModInitializer {

    public static final String MOD_ID = "architects_palette";
    public static final Logger LOGGER = LogManager.getLogger("Architect's Palette");
//    ApConfigs configs = AutoConfig.getConfigHolder(ApConfigs.class).getConfig();

    @Override
    public void onInitialize() {
        AutoConfig.register(ApConfigs.class, GsonConfigSerializer::new);
        APBlocks.registerBlocks();
        if(AutoConfig.getConfigHolder(ApConfigs.class).getConfig().enableVerticalSlabs) {
            LOGGER.info("vertslabson");
            FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
                ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("architects_palette", "vertslabs"), modContainer, ResourcePackActivationType.ALWAYS_ENABLED);
            });}
        APItems.registerItems();
        APItemgroup.registerItemgroup();
        APBlocks.registerFuel();

        APSounds.registerSounds();
        WarpingRecipe.registerRecipe();
        APTrades.registerVillagerTrades();
        APTrades.registerWanderingTrades();

        LootTableModifications.registerWitheredBones();
    }
}
