package xyz.chlamydomonos.fwi;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FireworkIndustry.MODID)
public class FireworkIndustry
{
    public static final String MODID = "fwi";

    private static final Logger LOGGER = LogUtils.getLogger();
}
