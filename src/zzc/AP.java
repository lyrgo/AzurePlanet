package zzc;

import arc.scene.style.Drawable;
import zzc.ui.APIcons;
import zzc.ui.APStyles;
import zzc.ui.APUI;

public class AP {

    public static final String modName = "ap";
    public static final String modDisplayName = " AzurePlanet ";
    public static final String modDisplayVersion = "[blue]v150beta[yellow]-[red]L";
    public static final double modVersion = 150;
    public static final String modGithub = "https://github.com/lyrgo/AzurePlanet";
    public static final String modQQ1 = "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=paxXLRc4QrwReDfLL0kEfNCh4XEs8Dbr&authKey=uJZyABvC7CykWajnq%2BJ5iQ2UX9J2aJafRSzlUya7E9mqk7H8Zv02eB%2FgZMJHcsyk&noverify=0&group_code=1031044470";
    public static final String modQQ2 = "http://qm.qq.com/cgi-bin/qm/qr?_wv=1027&k=74orWtwNKJIu98BTTZdhEyyggMRb6bnO&authKey=ERF1yRoVmmyV2Uan4DnXNm3sVYsMKCYLgcMf19JsL6nziqiWCvOD1SrImjdaqDqW&noverify=0&group_code=543522311";
    public static final Drawable modLogo = AzurePlanet.getModDrawable("lunch_logo");
    public static APUI ui;

    public static void init() {
        APStyles.load();
        APIcons.load();
        ui = new APUI();
        ui.init();
    }
}
