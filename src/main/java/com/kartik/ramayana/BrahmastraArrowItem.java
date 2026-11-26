package com.kartik.ramayana;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;

public class BrahmastraArrowItem extends ArrowItem {
    public BrahmastraArrowItem(Item.Properties props) { super(props); }
    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter, ItemStack weapon) {
        BrahmastraArrow arrow = new BrahmastraArrow(level, shooter, stack.copyWithCount(1), weapon);
        return arrow;
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, LivingEntity living) { return false; }
}
