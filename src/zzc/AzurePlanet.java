package zzc;

import arc.Core;
import arc.Events;
import arc.scene.style.Drawable;
import arc.util.Log;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import zzc.content.*;
import zzc.util.interfaces.LoadContent;

public class AzurePlanet extends Mod{

    public LoadContent[] loadContents = new LoadContent[]{
            new APItems(),    /*加载物品*/
            new APLiquids(),  /*加载液体*/
            new APUnits(),    /*加载单位*/
            new APStatus(),   /*加载状态*/
            new APBlocks(),   /*加载方块*/
            new APTechTree()  /*加载科技*/
    };

    public AzurePlanet(){
        Log.info("Loaded AzurePlanet constructor.");

        //监听Mod开始页面是否出现 (^_^)
        Events.on(EventType.ClientLoadEvent.class, e -> {
            AP.ui.mainMenu.show();
        });
    }

    @Override
    public void init() {
        super.init();
        AP.init();/*加载mod所有须加载的资源*/
    }

    @Override
    public void loadContent(){
        Log.info("Loading AzurePlanet content.");
        for (LoadContent loadContent : loadContents) loadContent.load();
        Log.info("AzurePlanet content load is ended");
    }

    public static <T extends Drawable> T getModDrawable(String name){
        return Core.atlas.getDrawable(AP.modName + "-" + name);
    }

}
