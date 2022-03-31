package xyz.sunrose.unobtrusivebats.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BatEntity.class)
public abstract class MixinBatEntity extends AmbientEntity {

    protected MixinBatEntity(EntityType<? extends AmbientEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean collides() {
        return false;
    }

    private static boolean isTodayAroundHalloween() {
        return false;
    }

}

