package xyz.sunrose.unobtrusivebats.mixin;

import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
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

    @Inject(at=@At("HEAD"), method = "play(Lnet/minecraft/client/sound/SoundInstance;)V", cancellable = true)
    private void dontPlay(SoundInstance soundInstance, CallbackInfo ci){
        for (Identifier sound : BATSOUNDS) {
            if(soundInstance.getId().equals(sound)){
                ci.cancel(); //don't play this
            }
        }
    }
}
