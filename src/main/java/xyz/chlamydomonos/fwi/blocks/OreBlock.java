package xyz.chlamydomonos.fwi.blocks;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import xyz.chlamydomonos.fwi.datagen.annotations.block.HasDefaultBlockItem;
import xyz.chlamydomonos.fwi.datagen.annotations.block.SimpleBlock;

import java.util.function.Supplier;

@HasDefaultBlockItem
@SimpleBlock(type = SimpleBlock.Type.CUBE_ALL)
public class OreBlock extends DropExperienceBlock {
    private final Supplier<Item> rawOre;

    public OreBlock(boolean isDeepslate, Supplier<Item> rawOre) {
        super(
                Properties.of()
                          .mapColor(isDeepslate ? MapColor.DEEPSLATE : MapColor.STONE)
                          .instrument(NoteBlockInstrument.BASEDRUM)
                          .requiresCorrectToolForDrops()
                          .strength(3.0F, 3.0F)
        );

        this.rawOre = rawOre;
    }

    public Item getRawOre() {
        return rawOre.get();
    }
}
