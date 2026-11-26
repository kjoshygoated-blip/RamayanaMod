package com.kartik.ramayana;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class BrahmastraArrow extends Arrow {
    public BrahmastraArrow(Level level, LivingEntity shooter, ItemStack stack, ItemStack weapon) {
        super(level, shooter, stack, weapon);
        this.setBaseDamage(100.0);
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            // Brahmastra - Blasts almost a whole chunk! (16x16)
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 12.0F, true, Level.ExplosionInteraction.TNT);
            this.discard();
        }
    }
}
