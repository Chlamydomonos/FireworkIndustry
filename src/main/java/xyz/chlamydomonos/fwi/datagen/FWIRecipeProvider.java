package xyz.chlamydomonos.fwi.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import xyz.chlamydomonos.fwi.recipes.FurnaceRecipes;

import java.util.List;
import java.util.function.Consumer;

public class FWIRecipeProvider extends RecipeProvider {
    public FWIRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        for(var recipe : FurnaceRecipes.RECIPES) {
            var input = recipe.input().get();
            var output = recipe.output().get();
            var exp = recipe.exp();
            var time = recipe.time();
            var name = recipe.name();

            oreSmelting(consumer, List.of(input), RecipeCategory.MISC, output, exp, time, name + "_smelting");
            oreBlasting(consumer, List.of(input), RecipeCategory.MISC, output, exp, time / 2, name + "_blasting");
        }
    }
}
