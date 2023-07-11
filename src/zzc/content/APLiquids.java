package zzc.content;

import mindustry.type.Liquid;
import zzc.util.interfaces.LoadContent;

import static arc.graphics.Color.valueOf;
import static mindustry.content.StatusEffects.corroded;

public class APLiquids implements LoadContent {

    public static Liquid
            cultureMedium/*培养液*/ , methane/*甲烷*/;

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

        methane = new Liquid("methane",valueOf("FBD367FF")) {{
            barColor = lightColor = color = valueOf("FBD367FF");
            flammability = 2.5f;
            temperature = 0.5f;
            heatCapacity = 0.5f;
            viscosity = 0.5f;
            explosiveness = 0;
            boilPoint = -1;
            effect = corroded;
        }};
    }
}
