package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.blocks.OreBlock;
import xyz.chlamydomonos.fwi.loaders.BlockLoader;

import java.util.concurrent.CompletableFuture;

public class FWIBlockTagProvider extends BlockTagsProvider {
    public FWIBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FireworkIndustry.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        for(var entry : BlockLoader.BLOCKS.getEntries()) {
            var block = entry.get();
            if(block instanceof OreBlock) {
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
            }
        }
    }
}
