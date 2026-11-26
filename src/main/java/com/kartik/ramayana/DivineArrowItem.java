package com.kartik.ramayana;

import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;

public class DivineArrowItem extends ArrowItem {
    public enum Type { FIRE, WATER, WIND }
    private final Type type;
    public DivineArrowItem(Item.Properties props, Type type) { super(props); this.type = type; }
    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter, ItemStack weapon) {
        DivineArrow arrow = new DivineArrow(level, shooter, stack.copyWithCount(1), weapon, type);
        return arrow;
    }
}
