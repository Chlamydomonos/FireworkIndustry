package xyz.chlamydomonos.fwi;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;
import xyz.chlamydomonos.fwi.loaders.BlockLoader;
import xyz.chlamydomonos.fwi.loaders.CreativeTabLoader;
import xyz.chlamydomonos.fwi.loaders.ItemLoader;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FireworkIndustry.MODID)
public class FireworkIndustry
{
    public static final String MODID = "fwi";

    public static final Logger LOGGER = LogUtils.getLogger();

    public FireworkIndustry() {
        CreativeTabLoader.registerAll();
        BlockLoader.registerAll();
        ItemLoader.registerAll();
    }
}
