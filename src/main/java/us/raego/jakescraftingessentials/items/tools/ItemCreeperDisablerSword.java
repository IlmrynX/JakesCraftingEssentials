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

package us.raego.jakescraftingessentials.items.tools;

import cofh.api.energy.IEnergyContainerItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCreeperDisablerSword extends BasicSwordItem implements IEnergyContainerItem {
    public ItemCreeperDisablerSword(String unlocalizedName, ToolMaterial p_i45356_1_) {
        super(unlocalizedName, p_i45356_1_);
    }

    @Override
    public int receiveEnergy(ItemStack itemStack, int i, boolean b) {
        return 0;
    }

    @Override
    public int extractEnergy(ItemStack itemStack, int i, boolean b) {
        return 0;
    }

    @Override
    public int getEnergyStored(ItemStack itemStack) {
        return 0;
    }

    @Override
    public int getMaxEnergyStored(ItemStack itemStack) {
        return 0;
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase playerEntity) {
        if(playerEntity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)playerEntity;
            ItemStack sword = player.getItemInUse();
            // Deal with energy handling here
        }

        return true;
    }
}
