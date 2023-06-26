package xyz.chlamydomonos.fwi.loaders;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.blocks.OreBlock;

import java.util.function.Supplier;

public class BlockLoader {
    @SuppressWarnings("ClassCanBeRecord")
    private static class RegisteredBlock {
        private final RegistryObject<? extends Block> block;
        private final RegistryObject<? extends Item> item;

        public RegisteredBlock(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item) {
            this.block = block;
            this.item = item;
        }

        public Block getBlock() {
            return block.get();
        }
        public Item getItem() {
            return item.get();
        }
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FireworkIndustry.MODID);

    public static final RegisteredBlock LEAD_ORE = register("lead_ore", () -> new OreBlock(false, ItemLoader.RAW_LEAD));
    public static final RegisteredBlock DEEPSLATE_LEAD_ORE = register("deepslate_lead_ore", () -> new OreBlock(true, ItemLoader.RAW_LEAD));


    public static RegisteredBlock register(String name, Supplier<Block> blockSupplier) {
        var block = BLOCKS.register(name, blockSupplier);
        var item = ItemLoader.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return new RegisteredBlock(block, item);
    }

    public static void registerAll() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
