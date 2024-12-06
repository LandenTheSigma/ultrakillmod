package com.ULTRAKILLMOD.init.Items;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, ULTRAKILLMOD.MODID);

    public static final Supplier<SoundEvent> PARRY = registerSoundEvent("parry");

    public static final Supplier<SoundEvent> MINOS_SPAWN = registerSoundEvent("minos_spawn");
    public static final Supplier<SoundEvent> MINOS_DIE = registerSoundEvent("minos_death");
    public static final Supplier<SoundEvent> MINOS_CRUSH = registerSoundEvent("minos_crush");
    public static final Supplier<SoundEvent> MINOS_JUDGEMENT = registerSoundEvent("minos_judgement");
    public static final Supplier<SoundEvent> MINOS_THYENDISNOW = registerSoundEvent("minos_thyendisnow");
    public static final Supplier<SoundEvent> MINOS_PREPARE_THYSELF = registerSoundEvent("minos_prepare_thyself");
    public static final Supplier<SoundEvent> MINOS_USELESS = registerSoundEvent("minos_useless");


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ULTRAKILLMOD.MODID,name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
