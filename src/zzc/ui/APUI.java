package zzc.ui;

import arc.assets.Loadable;
import zzc.ui.dialogs.AboutMod.MainMenu;
import zzc.ui.dialogs.AboutMod.ModChangelog;

public class APUI implements Loadable {

    public MainMenu mainMenu;
    public ModChangelog modChangelog;

    public void init() {
        mainMenu = new MainMenu();
        mainMenu.build();
        modChangelog = new ModChangelog();
        modChangelog.build();
    }
}
