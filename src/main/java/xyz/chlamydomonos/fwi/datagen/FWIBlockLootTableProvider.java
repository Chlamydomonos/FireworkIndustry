package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.blocks.OreBlock;
import xyz.chlamydomonos.fwi.loaders.BlockLoader;

import java.util.Collections;
import java.util.function.Supplier;

public class FWIBlockLootTableProvider extends BlockLootSubProvider {
    protected FWIBlockLootTableProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for(var entry : BlockLoader.BLOCKS.getEntries()) {
            var block = entry.get();
            if(block instanceof OreBlock) {
                add(block, createOreDrop(block, ((OreBlock) block).getRawOre()));
            }
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BlockLoader.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
    }
}
