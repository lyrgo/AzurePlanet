package zzc.content;

import mindustry.content.Planets;
import zzc.interfaces.LoadContent;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static zzc.content.APLiquids.*;

public class APTechTree implements LoadContent {
    @Override
    public void load() {
        Planets.serpulo.techTree = nodeRoot("serpulo", coreShard, () -> {
            node(cryofluid, () -> {
                node(cultureMedium);
            });
        });

//        nodeRoot("")
    }
}
