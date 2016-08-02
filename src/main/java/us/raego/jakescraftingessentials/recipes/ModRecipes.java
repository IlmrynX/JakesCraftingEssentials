package us.raego.jakescraftingessentials.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

/**
 * Created by Tristan on 7/27/2016.
 */
public class ModRecipes {
    public static void registerRecipes() {
        OreDictionary.registerOre("materialCoal", new ItemStack(Items.coal, 1, WILDCARD_VALUE));

        GameRegistry.addRecipe(new ShapedOreRecipe(Items.gunpowder,
                " C ",
                "GS ",
                " R ",
                'C', "materialCoal",
                'G', "dustGlowstone",
                'S', Items.sugar,
                'R', "dustRedstone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod, 2),
                "CGS",
                "GLN",
                "SNC",
                'C', "materialCoal",
                'G', "dustGlowstone",
                'S', "stickWood",
                'N', "gemQuartz",
                'L', Items.lava_bucket));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ender_pearl, 8),
                "LRL",
                "GDG",
                "LRL",
                'L', "gemLapis",
                'R', "blockRedstone",
                'G', "ingotGold",
                'D', "gemDiamond"));
    }
}
