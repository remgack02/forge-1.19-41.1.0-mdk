package net.remgack.testmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BluntItem extends Item {

    public BluntItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            hitBlunt(player);
            player.getCooldowns().addCooldown(this, 10);
        }

        return super.use(level, player, hand);
    }
    private void hitBlunt(Player player) {
        player.sendSystemMessage(Component.literal("Puff Puff Hit the Blunt"));
        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 0, false, true));
    }
}
