package com.teampotato.enchantdemon;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(EnchantDemon.ID)
@Mod.EventBusSubscriber()
public class EnchantDemon {
    public static final String ID = "enchantdemon";

    @SubscribeEvent
    public static void clearContainer(PlayerContainerEvent.Open event) {
        for (ItemStack itemStack : event.getContainer().getItems()) {
            if (!itemStack.getEnchantmentTags().isEmpty()) itemStack.getEnchantmentTags().clear();
        }
    }
}
