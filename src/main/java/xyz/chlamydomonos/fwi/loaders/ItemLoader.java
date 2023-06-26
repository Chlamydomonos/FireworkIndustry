package xyz.chlamydomonos.fwi.loaders;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.chlamydomonos.fwi.FireworkIndustry;
import xyz.chlamydomonos.fwi.items.DebugStickItem;
import xyz.chlamydomonos.fwi.items.DefaultItem;

public class ItemLoader {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FireworkIndustry.MODID);

    public static final RegistryObject<Item> DEBUG_STICK = ITEMS.register("debug_stick", DebugStickItem::new);
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", DefaultItem::new);
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead", DefaultItem::new);

    public static void registerAll() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
