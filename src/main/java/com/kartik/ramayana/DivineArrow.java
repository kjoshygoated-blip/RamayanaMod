package com.kartik.ramayana;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class DivineArrow extends Arrow {
    private final DivineArrowItem.Type type;
    public DivineArrow(Level level, LivingEntity shooter, ItemStack stack, ItemStack weapon, DivineArrowItem.Type type) {
        super(level, shooter, stack, weapon);
        this.type = type;
        this.setBaseDamage(20.0);
    }
    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity e = result.getEntity();
        if (type == DivineArrowItem.Type.FIRE) e.setRemainingFireTicks(100);
        if (type == DivineArrowItem.Type.WIND) {
            e.push(0, 2.0, 0);
            e.setDeltaMovement(e.getDeltaMovement().x * 3, 2.0, e.getDeltaMovement().z * 3);
        }
        if (type == DivineArrowItem.Type.WATER) e.clearFire();
    }
    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide()) {
            BlockPos pos = BlockPos.containing(result.getLocation());
            if (type == DivineArrowItem.Type.FIRE) {
                this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, true, Level.ExplosionInteraction.NONE);
            }
            if (type == DivineArrowItem.Type.WATER) {
                // Put out fire in 5x5 area
                for (int x=-2;x<=2;x++) for (int y=-1;y<=1;y++) for (int z=-2;z<=2;z++) {
                    BlockPos p = pos.offset(x,y,z);
                    if (this.level().getBlockState(p).is(net.minecraft.world.level.block.Blocks.FIRE)) {
                        this.level().setBlockAndUpdate(p, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState());
                    }
                }
            }
            this.discard();
        }
    }
}
