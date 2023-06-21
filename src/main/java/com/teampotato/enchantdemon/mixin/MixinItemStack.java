package com.teampotato.enchantdemon.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {
    @Shadow public abstract ListNBT getEnchantmentTags();

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    private void onTick(World pLevel, Entity pEntity, int pInventorySlot, boolean pIsCurrentItem, CallbackInfo ci) {
        if (!this.getEnchantmentTags().isEmpty()) this.getEnchantmentTags().clear();
    }
}
