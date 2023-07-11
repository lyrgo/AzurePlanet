package zzc.content;

import mindustry.type.Item;
import zzc.util.interfaces.LoadContent;

import static arc.graphics.Color.valueOf;

public class APItems implements LoadContent {

    public static Item
            diamond/*金刚石*/, cobalt/*钴*/, uranium/*铀*/, cadmium/*镉*/, cobaltSteel/*钴钢*/, siliconNitride/*氮化硅*/, biomass/*生物质*/, vectorAlloys/*矢量合金*/;

    @Override
    public void load() {
        diamond = new Item("diamond", valueOf("0029AFFF")) {{
            cost = 1.5f;
        }};

        cobalt = new Item("cobalt", valueOf("6977BFFF")) {{
            hardness = 2;
            cost = 0.7f;
        }};

        uranium = new Item("uranium", valueOf("2DC45AFF")) {{
            hardness = 3;
            radioactivity = 2;
            explosiveness = 0.7f;
            cost = 1;
        }};

        cadmium = new Item("cadmium", valueOf("ABABABFF")) {{
            hardness = 5;
            cost = 1.2f;
        }};

        cobaltSteel = new Item("cobaltSteel", valueOf("3D75F7FF")) {{
            explosiveness = 0.3f;
            cost = 1.0f;
        }};

        siliconNitride = new Item("siliconNitride", valueOf("DFDFDFFF")) {{
            cost = 1f;
        }};

        biomass = new Item("biomass", valueOf("DF824DFF")) {{
            cost = 0.5f;
            flammability = 0.8f;
        }};

        vectorAlloys = new Item("vectorAlloys", valueOf("F6BB64FF")) {{
            hardness = 0;
            radioactivity = 0;
            explosiveness = 1;
            flammability = 0;
            charge = 1.5f;
            cost = 1.5f;
            frames = 10;
        }};

    }
}
