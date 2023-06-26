package xyz.chlamydomonos.fwi.loaders;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xyz.chlamydomonos.fwi.FireworkIndustry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FireworkIndustry.MODID)
public class CreativeTabLoader {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FireworkIndustry.MODID);

    public static final RegistryObject<CreativeModeTab> TAB_FIREWORK = CREATIVE_MODE_TABS.register(
            "tab",
            () -> CreativeModeTab.builder()
                                 .title(Component.translatable("tab.firework.name"))
                                 .icon(() -> new ItemStack(Items.FIREWORK_ROCKET))
                                 .build()
    );

    public static void registerAll() {
        CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public static void onBuildTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == TAB_FIREWORK.get()) {
            for(var item : ItemLoader.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
