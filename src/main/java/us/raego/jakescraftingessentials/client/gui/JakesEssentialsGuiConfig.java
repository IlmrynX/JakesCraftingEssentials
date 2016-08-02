package us.raego.jakescraftingessentials.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import us.raego.jakescraftingessentials.JakesCraftingEssentials;

class JakesEssentialsGuiConfig extends GuiConfig {
        public JakesEssentialsGuiConfig(GuiScreen parent)
        {
            super(parent,
                    new ConfigElement(
                            JakesCraftingEssentials.config.getCategory(Configuration.CATEGORY_GENERAL))
                            .getChildElements(),
                    JakesCraftingEssentials.MODID,
                    false,
                    false,
                    "Jake\'s Crafting Essentials Config!");
            titleLine2 = JakesCraftingEssentials.config.toString();
        }
}
