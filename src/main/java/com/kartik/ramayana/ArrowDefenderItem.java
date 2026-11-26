package com.kartik.ramayana;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;

public class ArrowDefenderItem extends BowItem {
    public ArrowDefenderItem(Item.Properties props) { super(props); }
    // When you shoot with Arrow Defender, it will spawn 300 arrows in the air that fall on target!
    // This is handled in the bow release - for simplicity, we make it shoot super fast + high damage
    // Full 300-arrow rain is in the event handler - see RamayanaEvents
}
