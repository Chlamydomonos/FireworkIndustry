package xyz.chlamydomonos.fwi.recipes;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import xyz.chlamydomonos.fwi.loaders.ItemLoader;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class FurnaceRecipes {
    public record Recipe(Supplier<Item> input, Supplier<Item> output, float exp, int time, String name) {}
    public static Set<Recipe> RECIPES = new HashSet<>();

    static {
        addRecipe(ItemLoader.RAW_LEAD, ItemLoader.LEAD_INGOT, 0.7F, 200);
    }

    public static void addRecipe(Supplier<Item> input, RegistryObject<Item> output, float exp, int time) {
        RECIPES.add(new Recipe(input, output, exp, time, output.getId().getPath()));
    }
}
