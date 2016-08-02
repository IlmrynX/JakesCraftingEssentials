/*
 * The MIT License (MIT)
 * Copyright (c) 2016 shredder8910
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package us.raego.jakescraftingessentials.utils;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

public class RecipeUtils {
    public static void removeRecipes(IRecipe... recipesToRemove) {
        List recipes = CraftingManager.getInstance().getRecipeList();
        List<IRecipe> toRemove = Lists.newArrayList();

        for (Object obj : recipes) {
            if (obj instanceof IRecipe) {
                IRecipe recipe = (IRecipe) obj;
                for (IRecipe recipeToRemove : recipesToRemove) {
                    if (ItemStack.areItemStacksEqual(recipe.getRecipeOutput(), recipeToRemove.getRecipeOutput())) {
                        toRemove.add(recipe);
                    }
                }
            }
        }

        for (IRecipe recipe : toRemove) {
            recipes.remove(recipe);
        }
    }
}
