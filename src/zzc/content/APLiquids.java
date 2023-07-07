package zzc.content;

import mindustry.type.Liquid;
import zzc.interfaces.LoadContent;

import static arc.graphics.Color.valueOf;
import static mindustry.content.StatusEffects.corroded;

public class APLiquids implements LoadContent {

    public static Liquid
            cultureMedium/*培养液*/;

    @Override
    public void load() {

        cultureMedium = new Liquid("cultureMedium", valueOf("68FFCFFF")) {{
             flammability = 0.1f;
             temperature = 0.5f;
             heatCapacity = 0.5f;
             viscosity = 0.7f;
             explosiveness = 0;
             boilPoint = 0.5f;
             effect = corroded;
        }};
    }
}
