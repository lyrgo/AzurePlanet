package zzc.ui;

import arc.scene.style.Drawable;
import zzc.AzurePlanet;

public class APIcons{

    public static Drawable
        startIcon/*启动UI*/ , qqIcon /*QQ图标*/;

        public static void load() {
            startIcon = AzurePlanet.getModDrawable("icon_start");
            qqIcon = AzurePlanet.getModDrawable("icon_qq");
        }
}
