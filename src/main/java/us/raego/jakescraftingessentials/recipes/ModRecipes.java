package us.raego.jakescraftingessentials.recipes;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import us.raego.jakescraftingessentials.JakesCraftingEssentials;
import us.raego.jakescraftingessentials.utils.RecipeUtils;

import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

public class ModRecipes {
    private static int BLAZE_ROD_AMOUNT = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "Blaze Rods From Recipe", 2).getInt();
    private static int ENDER_PEARL_AMOUNT = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "Ender Pearls From Recipe", 8).getInt();

    private static IRecipe gunpowderRecipe;
    private static IRecipe blazeRodRecipe;
    private static IRecipe enderPearlRecipe;

    public static void registerRecipes() {
        OreDictionary.registerOre("materialCoal", new ItemStack(Items.coal, 1, WILDCARD_VALUE));

        GameRegistry.addRecipe(gunpowderRecipe = new ShapedOreRecipe(Items.gunpowder,
                " C ",
                "GS ",
                " R ",
                'C', "materialCoal",
                'G', "dustGlowstone",
                'S', Items.sugar,
                'R', "dustRedstone"));

        GameRegistry.addRecipe(blazeRodRecipe = new ShapedOreRecipe(new ItemStack(Items.blaze_rod, BLAZE_ROD_AMOUNT),
                "CGS",
                "GLN",
                "SNC",
                'C', "materialCoal",
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

    public static void updateModRecipesFromConfig() {
        RecipeUtils.removeRecipes(blazeRodRecipe, enderPearlRecipe);

        System.out.println("Recipe removal done?");

        blazeRodRecipe.getRecipeOutput().stackSize = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "BlazeRodsFromRecipe", 2).getInt();
        enderPearlRecipe.getRecipeOutput().stackSize = JakesCraftingEssentials.config.get(Configuration.CATEGORY_GENERAL, "EnderPearlsFromRecipe", 8).getInt();

        GameRegistry.addRecipe(blazeRodRecipe);
        GameRegistry.addRecipe(enderPearlRecipe);
    }
}
