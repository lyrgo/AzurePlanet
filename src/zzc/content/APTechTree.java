package zzc.content;

import mindustry.content.Planets;
import zzc.util.interfaces.LoadContent;

import static mindustry.content.Blocks.coreShard;
import static mindustry.content.Blocks.cryofluid;
import static mindustry.content.TechTree.node;
import static mindustry.content.TechTree.nodeRoot;
import static zzc.content.APLiquids.cultureMedium;

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
