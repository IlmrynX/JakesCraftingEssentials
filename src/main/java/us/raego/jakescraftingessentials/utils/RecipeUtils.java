package us.raego.jakescraftingessentials.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class RecipeUtils {
    public static void removeRecipes(IRecipe... recipesToRemove) {
        List recipes = CraftingManager.getInstance().getRecipeList();

        for (int i = 0; i < recipes.size(); i++) {
            Object obj = recipes.get(i);
            if (obj instanceof IRecipe) {
                IRecipe recipe = (IRecipe) obj;
                for (IRecipe recipeToRemove : recipesToRemove) {
                    if (ItemStack.areItemStacksEqual(recipe.getRecipeOutput(), recipeToRemove.getRecipeOutput())) {
                        System.out.println("Removed Recipe: " + recipe + " -> " + recipe.getRecipeOutput());
                        recipes.remove(recipe);
                        i--;
                        break;
                    }
                }
            }
        }
    }
}
