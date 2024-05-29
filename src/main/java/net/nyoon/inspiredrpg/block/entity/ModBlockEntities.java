package net.nyoon.inspiredrpg.block.entity;

import com.google.common.collect.ImmutableSet;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nyoon.inspiredrpg.InspiredRPG;
import net.nyoon.inspiredrpg.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<StoveBlockEntity> STOVE_BLOCK_ENTITY = 
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(InspiredRPG.MOD_ID, "stove_be"), 
            BlockEntityType.Builder.create(StoveBlockEntity::new, ModBlocks.STOVE_BLOCK).build());
}
