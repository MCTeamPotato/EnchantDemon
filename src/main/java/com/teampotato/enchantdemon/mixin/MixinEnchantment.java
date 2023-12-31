package com.teampotato.enchantdemon.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Enchantment.class, priority = 9999)
public abstract class MixinEnchantment {
    @Inject(method = "canApplyAtEnchantingTable", at = @At("HEAD"), cancellable = true, remap = false)
    private void onApply(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        cir.cancel();
    }
}
