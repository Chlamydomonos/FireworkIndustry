package xyz.chlamydomonos.fwi.datagen;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xyz.chlamydomonos.fwi.FireworkIndustry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FireworkIndustry.MODID)
public class DataLoader {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var packOutput = event.getGenerator().getPackOutput();
        var lookupProvider = event.getLookupProvider();
        var existingFileHelper = event.getExistingFileHelper();
        var generator = event.getGenerator();

        var includeClient = event.includeClient();
        var includeServer = event.includeServer();

        generator.addProvider(includeClient, new FWIBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(includeClient, new FWIItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(includeServer, new FWILootTableProvider(packOutput));
        generator.addProvider(includeServer, new FWIBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(includeServer, new FWIRecipeProvider(packOutput));
    }
}
