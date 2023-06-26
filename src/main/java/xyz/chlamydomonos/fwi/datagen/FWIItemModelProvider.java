package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.datagen.annotations.item.GeneratedItem;
import xyz.chlamydomonos.fwi.datagen.annotations.item.HandheldItem;
import xyz.chlamydomonos.fwi.datagen.annotations.block.HasDefaultBlockItem;
import xyz.chlamydomonos.fwi.loaders.ItemLoader;

public class FWIItemModelProvider extends ItemModelProvider {
    private static final ResourceLocation GENERATED = new ResourceLocation("minecraft", "item/generated");
    private static final ResourceLocation HANDHELD = new ResourceLocation("minecraft", "item/handheld");

    public FWIItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FireworkIndustry.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var entry : ItemLoader.ITEMS.getEntries()) {
            var item = entry.get();
            var itemClass = item.getClass();
            var itemName = entry.getId().getPath();
            var itemTexture = new ResourceLocation(FireworkIndustry.MODID, "item/" + entry.getId().getPath());

            var isGenerated = itemClass.getAnnotation(GeneratedItem.class) != null;
            if (isGenerated) {
                withExistingParent(itemName, GENERATED).texture("layer0", itemTexture);
            }

            var isHandheld = itemClass.getAnnotation(HandheldItem.class) != null;
            if (isHandheld) {
                withExistingParent(itemName, HANDHELD).texture("layer0", itemTexture);
            }

            if(item instanceof BlockItem) {
                var blockClass = ((BlockItem) item).getBlock().getClass();

                var isBlockItem = blockClass.getAnnotation(HasDefaultBlockItem.class) != null;
                if (isBlockItem) {
                    withExistingParent(itemName, new ResourceLocation(FireworkIndustry.MODID, "block/" + itemName));
                }
            }
        }
    }
}
