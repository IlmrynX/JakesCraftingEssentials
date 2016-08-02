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

package us.raego.jakescraftingessentials;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import us.raego.jakescraftingessentials.common.CommonProxy;
import us.raego.jakescraftingessentials.events.EventConfigChanged;

@Mod(modid = JakesCraftingEssentials.MODID,
        name = JakesCraftingEssentials.MODNAME,
        version = JakesCraftingEssentials.VERSION,
        guiFactory = "us.raego.jakescraftingessentials.client.gui.JakesEssentialsGuiFactory")
public class JakesCraftingEssentials
{
    public static final String MODID = "jakescraftingessentials";
    public static final String MODNAME = "Jake\'s Crafting Essentials";
    public static final String VERSION = "1.1";

    @SidedProxy(clientSide = "us.raego.jakescraftingessentials.client.ClientProxy",
                serverSide = "us.raego.jakescraftingessentials.common.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration config;

    @Mod.Instance(MODID)
    public static JakesCraftingEssentials instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        config = new Configuration(e.getSuggestedConfigurationFile());
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(new EventConfigChanged());

        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}

