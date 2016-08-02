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

package us.raego.jakescraftingessentials.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
import us.raego.jakescraftingessentials.JakesCraftingEssentials;
import us.raego.jakescraftingessentials.utils.RecipeUtils;

import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

public class ModRecipes {
    private static int GUNPOWDER_AMOUNT;
    private static int BLAZE_ROD_AMOUNT;
    private static int ENDER_PEARL_AMOUNT;

    private static IRecipe gunpowderRecipe;
    private static IRecipe blazeRodRecipe;
    private static IRecipe enderPearlRecipe;

    public static void registerRecipes() {
        GameRegistry.addRecipe(gunpowderRecipe = new ShapedOreRecipe(new ItemStack(Items.gunpowder, GUNPOWDER_AMOUNT),
                " C ",
                "GS ",
                " R ",
                'C', new ItemStack(Items.coal, 1, WILDCARD_VALUE),
                'G', "dustGlowstone",
                'S', Items.sugar,
                'R', "dustRedstone"));

        GameRegistry.addRecipe(blazeRodRecipe = new ShapedOreRecipe(new ItemStack(Items.blaze_rod, BLAZE_ROD_AMOUNT),
                "CGS",
                "GLN",
                "SNC",
                'C', new ItemStack(Items.coal, 1, WILDCARD_VALUE),
                'G', "dustGlowstone",
                'S', "stickWood",
                'N', "gemQuartz",
                'L', Items.lava_bucket));

        GameRegistry.addRecipe(enderPearlRecipe = new ShapedOreRecipe(new ItemStack(Items.ender_pearl, ENDER_PEARL_AMOUNT),
                "LRL",
                "GDG",
                "LRL",
                'L', "gemLapis",
                'R', "blockRedstone",
                'G', "ingotGold",
                'D', "gemDiamond"));
    }

    public static void updateRecipesFromConfig() {
        GUNPOWDER_AMOUNT = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "Gunpowder from recipe", 1).getInt();
        BLAZE_ROD_AMOUNT = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "Blaze Rods from recipe", 2).getInt();
        ENDER_PEARL_AMOUNT = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "Ender Pearls from recipe", 8).getInt();
    }

    public static void updateRecipesInCraftingManager() {
        RecipeUtils.removeRecipes(gunpowderRecipe, blazeRodRecipe, enderPearlRecipe);

        gunpowderRecipe.getRecipeOutput().stackSize = GUNPOWDER_AMOUNT;
        blazeRodRecipe.getRecipeOutput().stackSize = BLAZE_ROD_AMOUNT;
        enderPearlRecipe.getRecipeOutput().stackSize = ENDER_PEARL_AMOUNT;

        GameRegistry.addRecipe(gunpowderRecipe);
        GameRegistry.addRecipe(blazeRodRecipe);
        GameRegistry.addRecipe(enderPearlRecipe);
    }
}
