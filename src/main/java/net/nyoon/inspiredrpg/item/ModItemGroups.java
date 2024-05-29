package net.nyoon.inspiredrpg.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nyoon.inspiredrpg.InspiredRPG;
import net.nyoon.inspiredrpg.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TEST_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(InspiredRPG.MOD_ID, "test"), 
    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.testgroup")).icon(() -> new ItemStack(ModItems.TEST)).entries((displayContext, entries) -> {
        //Add all custom items to item group here
        entries.add(ModItems.TEST);

        //Add all custom blocks to item group here
        entries.add(ModBlocks.STOVE_BLOCK);

    }).build());
    
    public static void registerItemGroups() {
        InspiredRPG.LOGGER.info("Registering Item Groups for " + InspiredRPG.MOD_ID);
    }
}
