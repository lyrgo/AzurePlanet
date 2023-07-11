package zzc.content;

import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.StatusEffect;
import zzc.util.interfaces.LoadContent;

import static arc.graphics.Color.valueOf;

public class APStatus implements LoadContent {

    public static StatusEffect
            repair/*修复*/, parasitism/*寄生*/ , radiation/*辐射*/;

    @Override
    public void load() {

        repair = new StatusEffect("repair") {{
            color = valueOf("0A6408FF");
            damageMultiplier = 1;
            healthMultiplier = 1;
            speedMultiplier = 1;
            reloadMultiplier = 1;
            damage = -0.05f;

            permanent = false;
            reactive = false;
            disarm = false;

            effect = new WaveEffect() {{
                lifetime = 10;
                sizeFrom = 0;
                sizeTo = 1.7f;
                colorTo = colorFrom = valueOf("0A6408FF");
            }};

            effectChance = 500;
        }};

        parasitism = new StatusEffect("parasitism") {{
            damageMultiplier = 0.9f;
            healthMultiplier = 0.9f;
            speedMultiplier = 0.9f;
            reloadMultiplier = 0.8f;
            damage = 0.05f;
            permanent = false;
            color = valueOf("9E78DCFF");
            disarm = false;

            effect = new ParticleEffect() {{
                particles = 1;
                sizeFrom = 1;
                sizeTo = 0;
                length = 30;
                baseLength = 1;
                colorFrom = valueOf("AF3A30FF");
                colorTo = valueOf("DF824DFF");
                spin = 1;
            }};

            effectChance = 0.05f;
        }};

        radiation = new StatusEffect("radiation") {{
            damageMultiplier = 1;
            healthMultiplier = 1;
            speedMultiplier = 1;
            reloadMultiplier = 1;
            damage = 0.3f;
            permanent = false;
            reactive = false;
            color = valueOf("0A6408FF");
            disarm = false;

            effect = new WaveEffect() {{
                lifetime = 10;
                sizeFrom = 0;
                sizeTo = 1.7f;
                colorTo = colorFrom = valueOf("0A6408FF");
            }};

            effectChance = 0.5f;
        }};
    }
}
