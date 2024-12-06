package com.ULTRAKILLMOD.Client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VFXHandler {
    public static void explosionRing(float size, int particleCount, Vec3 pos, double particleSpeed) {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;

        if (level != null) {
            for (int i = 0; i < particleCount; i++) {
                // Calculate the angle for this particle (evenly distributed in a circle)
                double angle = 2 * Math.PI * i / particleCount;

                // Calculate the particle's starting position
                double xOffset = Math.cos(angle) * size;
                double zOffset = Math.sin(angle) * size;

                // Calculate the particle's velocity (outward direction from the center)
                double xVelocity = Math.cos(angle) * particleSpeed;
                double zVelocity = Math.sin(angle) * particleSpeed;

                // Spawn the particle
                minecraft.particleEngine.createParticle(
                        ParticleTypes.EXPLOSION,
                        pos.x + xOffset,
                        pos.y,
                        pos.z + zOffset,
                        xVelocity,
                        0.0, // Vertical velocity (set to 0 for a flat ring)
                        zVelocity
                );
            }
        }
    }

}
