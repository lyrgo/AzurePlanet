package zzc.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.abilities.LiquidExplodeAbility;
import mindustry.entities.abilities.LiquidRegenAbility;
import mindustry.entities.abilities.MoveEffectAbility;
import mindustry.entities.abilities.RegenAbility;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.bullet.ExplosionBulletType;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.CrawlUnit;
import mindustry.gen.Sounds;
import mindustry.gen.TimedKillUnit;
import mindustry.gen.UnitEntity;
import mindustry.type.AmmoType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.unit.*;
import mindustry.world.meta.BlockFlag;
import zzc.interfaces.LoadContent;

import static arc.graphics.Color.valueOf;

public class APUnits implements LoadContent {

    public static UnitType gtx690/*GTX690*/, maggots/*蛆虫*/, leeches/*蟥蛭*/;

    @Override
    public void load() {
        gtx690 = new MissileUnitType("gtx690") {{

            constructor = TimedKillUnit::create;

            health = 1080;
            armor = 6;
            speed = 6;
            lifetime = 400;
            maxRange = 6;
            rotateSpeed = 1.2f;
            engineColor = trailColor = valueOf("FEB380");
            engineLayer = 100;
            engineSize = 3.1f;
            engineOffset = 10;
            trailLength = 18;
            missileAccelTime = 60;
            lowAltitude = true;
            fogRadius = 8;
            outlineColor = valueOf("6E7080FF");
            weapons.add(new Weapon("gtx690-weapon") {{
                shootCone = 360;
                mirror = false;
                reload = 1;
                shake = 10;
                shootOnDeath = true;
                shootSound = Sounds.plasmaboom;
                bullet = new ExplosionBulletType() {{
                    hitColor = valueOf("FFB381FF");
                    shootEffect = new MultiEffect() {{
                        effects = new Effect[]{Fx.titanExplosion, Fx.titanSmoke};

                        splashDamage = 3000;
                        splashDamageRadius = 120;
                        despawnShake = 3;
                        fragVelocityMin = 1;
                    }};
                }};

                abilities.add(new MoveEffectAbility() {{
                    effect = Fx.missileTrailSmoke;
                    rotation = 180;
                    y = -10;
                    color = valueOf("FEB38080");
                    interval = 9;
                }});
            }});
        }};

        maggots = new UnitType("maggots") {{

            constructor = CrawlUnit::create;

            health = 250;
            hitSize = 9;
            omniMovement = true;
            rotateSpeed = 5;
            drownTimeMultiplier = 2;
            segments = 3;
            drawBody = false;
            hidden = false;
            crushDamage = 0.5f;
            targetAir = true;
            targetGround = true;
            segmentScl = 3;
            segmentPhase = 5;
            segmentMag = 0.5f;
            speed = 1.2f;
            drawCell = true;
            outlineColor = valueOf("2C2A35FF");
            abilities.add(new RegenAbility() {{
                percentAmount = 0.035f;
            }}, new LiquidExplodeAbility() {{
                liquid = Liquids.neoplasm;
                amount = 60;
                radAmountScale = 1;
                noiseMag = 10;
                noiseScl = 5;
            }}, new LiquidRegenAbility() {{
                liquid = Liquids.neoplasm;
                slurpEffect = Fx.neoplasmHeal;
            }});
            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24;
                shootCone = 180;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                mirror = false;
                bullet = new BasicBulletType() {{
                    collidesTiles = false;
                    collidesAir = true;
                    collides = false;
                    hitSound = Sounds.explosion;
                    rangeOverride = 30;
                    hitEffect = Fx.pulverize;
                    speed = 0;
                    splashDamageRadius = 55;
                    instantDisappear = true;
                    splashDamage = 90;
                    killShooter = true;
                    hittable = false;
                }};
            }});
        }};

        leeches = new UnitType("leeches") {{

            constructor = UnitEntity::create;

            flying = true;
            health = 750;
            speed = 1.5f;
            accel = 0.08f;
            drag = 0.06f;
            hitSize = 20;
            targetAir = false;
            engineSize = 0;
            range = 100;
            faceTarget = false;
            armor = 3;
            itemCapacity = 20;
            circleTarget = true;
            outlineColor = valueOf("2C2A35FF");
            crashDamageMultiplier = 0.5f;
            abilities.add(new RegenAbility() {{
                percentAmount = 0.03f;
            }}, new LiquidExplodeAbility() {{
                liquid = Liquids.neoplasm;
                amount = 60;
                radAmountScale = 2;
                radScale = 1.1f;
                noiseMag = 10;
                noiseScl = 10;
            }});

            targetFlags = new BlockFlag[]{BlockFlag.generator, BlockFlag.factory};
            weapons.add(new Weapon() {{
                minShootVelocity = 0.75f;
                x = 0;
                y = 3;
                mirror = true;
                reload = 12;
                shootCone = 180;
                inaccuracy = 15;
                ignoreRotation = true;
                shootSound = Sounds.none;
                bullet = new BombBulletType() {{
                    width = 10;
                    height = 14;
                    damage = 33;
                    splashDamage = 33;
                    splashDamageRadius = 18;
                    hitEffect = Fx.flakExplosion;
                    shootEffect = Fx.none;
                    smokeEffect = Fx.none;
                    backColor = frontColor = valueOf("D72000FF");
                    fragBullets = 15;
                    fragBullet = new LiquidBulletType() {{
                        liquid = Liquids.neoplasm;
                        lifetime = 1;
                        speed = 1;
                        puddleSize = 5;
                        orbSize = 5;
                        damage = 0;
                    }};
                }};
            }});
            parts.add(new RegionPart() {{
                mirror = true;
                x = 0;
                y = 0;
                layer = 56;
                suffix = "-side";
                moveX = 0;
                moveY = 0;
                moveRot = 10;
                progress = PartProgress.smoothReload;
            }});
        }};
    }
}
