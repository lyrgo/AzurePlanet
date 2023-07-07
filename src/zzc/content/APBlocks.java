package zzc.content;

import arc.struct.Seq;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.BuildVisibility;
import zzc.interfaces.LoadContent;
import zzc.world.blocks.RestoreCore;

import static mindustry.content.Items.*;
import static zzc.content.APItems.*;
import static zzc.content.APLiquids.*;
import static zzc.content.APUnits.*;

public class APBlocks implements LoadContent {

    public static Block
            firstGenerationCultivators/*初代培养机*/ , restoreCore/*恢复核心*/;

    @Override
    public void load() {

        firstGenerationCultivators = new UnitFactory("firstGenerationCultivators") {{
            health = 360;
            size = 3;
            consumeLiquid(cultureMedium,0.1f);
            consumePower(2);

            plans = Seq.with(
                new UnitPlan(maggots,900, ItemStack.with(silicon,10,biomass,20))
            );
        }};

        restoreCore = new RestoreCore("restoreCore") {{
            size = 3;
            health = 1500;
            configurable = true;
            buildVisibility = BuildVisibility.shown;
            requirements(Category.effect,ItemStack.with(graphite, 1500, cobalt, 1200));
            solid = true;
            update = true;
            unitCapModifier = 12;
            itemCapacity = 3000;
            destructible = true;
        }};
    }
}
