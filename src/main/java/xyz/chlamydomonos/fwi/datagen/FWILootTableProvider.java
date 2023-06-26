package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;
import java.util.List;

public class FWILootTableProvider extends LootTableProvider {
    public FWILootTableProvider(PackOutput packOutput) {
        super(packOutput, Collections.emptySet(), List.of(
                new SubProviderEntry(FWIBlockLootTableProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
