package net.nyoon.inspiredrpg.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nyoon.inspiredrpg.InspiredRPG;

public class ModItems {
    //Declarations of all items in mod
    public static final Item TEST = registerItem("testitem", new Item(new Item.Settings()));

    //TEMPORARY adds test item to Ingredients tab in creative inventory
    public static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(TEST);
    }

    //Registers items to add them to the game
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(InspiredRPG.MOD_ID, name), item);
    }

    public static void registerModItems() {
        InspiredRPG.LOGGER.info("Registering Mod Items for " + InspiredRPG.MOD_ID);

        //TEMPORARY runs method that adds items to ingredient tab in creative inventory
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
