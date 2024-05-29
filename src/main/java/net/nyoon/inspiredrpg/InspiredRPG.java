package net.nyoon.inspiredrpg;

import net.fabricmc.api.ModInitializer;
import net.nyoon.inspiredrpg.item.ModItemGroups;
import net.nyoon.inspiredrpg.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InspiredRPG implements ModInitializer {
	public static final String MOD_ID = "inspiredrpg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}