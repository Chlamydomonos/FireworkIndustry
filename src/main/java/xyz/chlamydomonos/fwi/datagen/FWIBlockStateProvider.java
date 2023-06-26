package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.datagen.annotations.block.SimpleBlock;
import xyz.chlamydomonos.fwi.loaders.BlockLoader;

public class FWIBlockStateProvider extends BlockStateProvider {
    public FWIBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FireworkIndustry.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(var entry : BlockLoader.BLOCKS.getEntries()) {
            var block = entry.get();
            var blockClass = block.getClass();

            SimpleBlock simpleBlock;
            if((simpleBlock = blockClass.getAnnotation(SimpleBlock.class)) != null) {
                switch (simpleBlock.type()) {

                case CUBE_ALL -> simpleBlock(block);
                case CUSTOM_MODEL -> {
                    assert entry.getKey() != null;
                    simpleBlock(block, new ModelFile.ExistingModelFile(
                            new ResourceLocation(
                                    FireworkIndustry.MODID,
                                    "block/" + entry.getKey().location().getPath()
                            ),
                            models().existingFileHelper
                    ));
                }
                }
            }
        }
    }
}
