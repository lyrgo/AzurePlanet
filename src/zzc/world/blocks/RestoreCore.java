package zzc.world.blocks;

import mindustry.world.blocks.storage.CoreBlock;

public class RestoreCore extends CoreBlock {

    public int amountRecovery = 10;

    public RestoreCore(String name) {
        this(name,10);
    }

    public RestoreCore(String name , int amountRecovery) {
        super(name);
        this.amountRecovery = amountRecovery;
    }

    public class RestoreCoreBuild extends CoreBuild {

        @Override
        public void update() {
            super.update();
            if(health < maxHealth && timer.get(15)) {
                health += amountRecovery;
            }
            if(health > maxHealth) health -= maxHealth - health;
        }
    }
}
