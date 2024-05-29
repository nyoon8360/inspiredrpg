package net.nyoon.inspiredrpg.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nyoon.inspiredrpg.InspiredRPG;

public class ModBlocks {
    public static final Block STOVE_BLOCK = registerBlock("stove_block", 
        new Block(AbstractBlock.Settings.copy(Blocks.FURNACE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(InspiredRPG.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(InspiredRPG.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        InspiredRPG.LOGGER.info("Registering ModBlocks for " + InspiredRPG.MOD_ID);
    }
}
