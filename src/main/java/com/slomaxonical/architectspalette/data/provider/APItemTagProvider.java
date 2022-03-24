package com.slomaxonical.architectspalette.data.provider;

import com.slomaxonical.architectspalette.ArchitectsPalette;
import com.slomaxonical.architectspalette.registry.APBlocks;
import com.slomaxonical.architectspalette.registry.APItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.Nullable;

public class APItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public APItemTagProvider(FabricDataGenerator dataGenerator, @Nullable BlockTagProvider blockTagProvider) {super(dataGenerator, blockTagProvider);
    }
    //APTags
    public static final TagKey<Item> TWISTED_LOGS = TagKey.of(Registry.ITEM_KEY,new Identifier(ArchitectsPalette.MOD_ID, "twisted_logs")); //i think this once can be removed
    public static final TagKey<Item> OLIVESTONE = TagKey.of(Registry.ITEM_KEY,new Identifier(ArchitectsPalette.MOD_ID, "olivestone"));
    public static final TagKey<Item> OLIVESTONE_SLABS = TagKey.of(Registry.ITEM_KEY,new Identifier(ArchitectsPalette.MOD_ID, "olivestone_slabs"));
    //common tags
    public static final TagKey<Item> WITHERED_BONES = TagKey.of(Registry.ITEM_KEY,new Identifier("c", "withered_bones"));
    public static final TagKey<Item> MUSHROOMS = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "mushrooms"));

    //not used
    private FabricTagBuilder<Item> getOrCreateTagBuilder(Identifier id) {
        TagKey<Item> tag = TagKey.of(Registry.ITEM_KEY, id);
        return this.getOrCreateTagBuilder(tag);
    }
    //may use
    private void copy(Identifier id) {
        TagKey<Block> blockTag = TagKey.of(Registry.BLOCK_KEY, id);
        TagKey<Item> itemTag = TagKey.of(Registry.ITEM_KEY, id);
        this.copy(blockTag, itemTag);
    }
    @Override
    protected void generateTags() {
        this.copy(APBlockTagProvider.TWISTED_LOGS, TWISTED_LOGS);
        this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(TWISTED_LOGS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.SLABS,ItemTags.SLABS);
        this.copy(BlockTags.STAIRS,ItemTags.STAIRS);
        this.copy(BlockTags.WALLS,ItemTags.WALLS);
        this.copy(BlockTags.WOODEN_BUTTONS,ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_DOORS,ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_FENCES,ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES,ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_SLABS,ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS,ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_TRAPDOORS,ItemTags.WOODEN_TRAPDOORS);

        this.getOrCreateTagBuilder(MUSHROOMS)
                .add(Items.RED_MUSHROOM)
                .add(Items.BROWN_MUSHROOM);

        this.getOrCreateTagBuilder(OLIVESTONE)
                .add(APBlocks.OLIVESTONE_BRICKS.asItem())
                .add(APBlocks.OLIVESTONE_TILE.asItem());

        this.getOrCreateTagBuilder(OLIVESTONE_SLABS)
                .add(APBlocks.OLIVESTONE_BRICK_SET.SLAB.asItem())
                .add(APBlocks.OLIVESTONE_TILES_SET.SLAB.asItem());

        this.getOrCreateTagBuilder(WITHERED_BONES).add(APItems.WITHERED_BONE);
    }

}