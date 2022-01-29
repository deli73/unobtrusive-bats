package xyz.sunrose.unobtrusivebats.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BatEntity.class)
public abstract class MixinBatEntity extends AmbientEntity {

    protected MixinBatEntity(EntityType<? extends AmbientEntity> entityType, World world) {
        super(entityType, world);
    }

    /*@Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("TAIL"))
    private void injectConstructor(EntityType<? extends BatEntity> entityType, World world, CallbackInfo info) {
        this.setSilent(true);
    }*/

    @Override
    public float getSoundVolume() {
        return 0F;
    }

    @Override
    public boolean collides() {
        return false;
    }

    private static boolean isTodayAroundHalloween() {
        return false;
    }

}

