package xyz.sunrose.unobtrusivebats.mixin;

import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SoundSystem.class)
public class MixinSoundSystem {
    private static final Identifier[] BATSOUNDS = {
            SoundEvents.ENTITY_BAT_AMBIENT.getId(),
            SoundEvents.ENTITY_BAT_LOOP.getId(),
            SoundEvents.ENTITY_BAT_DEATH.getId(),
            SoundEvents.ENTITY_BAT_HURT.getId(),
            SoundEvents.ENTITY_BAT_TAKEOFF.getId()
    };


    @Inject(at=@At("HEAD"), method="getAdjustedVolume", cancellable=true)
    private void changeAdjustedVolume(SoundInstance soundInstance, CallbackInfoReturnable<Float> ci) {
        for (Identifier sound : BATSOUNDS) {
            if(soundInstance.getId().equals(sound)){
                ci.setReturnValue(0f); // shhhhh
            }
        }
    }
}
