package com.teampotato.enchantdemon.mixin;

import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class MixinItemStack {
    @Shadow public abstract ListTag getEnchantmentTags();

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    private void onTick(Level pLevel, Entity pEntity, int pInventorySlot, boolean pIsCurrentItem, CallbackInfo ci) {
        if (pIsCurrentItem && !this.getEnchantmentTags().isEmpty()) this.getEnchantmentTags().clear();
    }
}
