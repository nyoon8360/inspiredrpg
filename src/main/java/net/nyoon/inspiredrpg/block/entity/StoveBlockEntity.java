package net.nyoon.inspiredrpg.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class StoveBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;

    //Slot identifiers
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    
    //Cooking progress ints
    private int progress = 0;
    private int maxProgress = 72;

    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STOVE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> StoveBlockEntity.this.progress;
                    case 1 -> StoveBlockEntity.this.progress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> StoveBlockEntity.this.progress = value;
                    case 1 -> StoveBlockEntity.this.maxProgress = value;
                };
            }

            @Override
            public int size() {
                return 2;
            }
        }; 
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("stove.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("stove.progress");
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Stove");
    }

    @Override
    public ScreenHandler createMenu(int var1, PlayerInventory var2, PlayerEntity var3) {
        return;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
}
