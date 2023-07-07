package zzc;

import arc.Core;
import arc.scene.style.Drawable;
import zzc.ui.APIcons;
import zzc.ui.APStyles;
import zzc.ui.APUI;

public class AP {

    public static final String modName = "ap";
    public static final String modDisplayName = " AzurePlanet ";
    public static final String modVersion = "[blue]v150beta[yellow]-[red]L";
    public static final Drawable modLogo = AzurePlanet.getModDrawable("lunch_logo");
    public static APUI ui;

    public static void init() {
        APStyles.load();
        APIcons.load();
        ui = new APUI();
        ui.init();
    }
}
