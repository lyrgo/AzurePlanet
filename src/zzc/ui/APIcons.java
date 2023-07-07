package zzc.ui;

import arc.Core;
import arc.scene.style.Drawable;
import zzc.AP;
import zzc.AzurePlanet;

public class APIcons{

    public static Drawable
        startIcon/*启动UI*/;

        public static void load() {
            startIcon = AzurePlanet.getModDrawable("icon_start");
        }
}
