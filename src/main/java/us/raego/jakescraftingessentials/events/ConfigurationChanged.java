package us.raego.jakescraftingessentials.events;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import us.raego.jakescraftingessentials.JakesCraftingEssentials;
import us.raego.jakescraftingessentials.recipes.ModRecipes;

public class ConfigurationChanged {
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.modID.equals(JakesCraftingEssentials.MODID))
            syncConfig();
    }

    private static void syncConfig() {
        ModRecipes.updateModRecipesFromConfig();

        if(JakesCraftingEssentials.config.hasChanged())
            JakesCraftingEssentials.config.save();
    }
}
