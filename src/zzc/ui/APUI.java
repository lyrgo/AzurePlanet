package zzc.ui;

import arc.assets.Loadable;
import zzc.ui.dialogs.AboutMod.MainMenu;

public class APUI implements Loadable {

    public MainMenu mainMenu;

    public void init() {
        mainMenu = new MainMenu();
        mainMenu.build();
    }
}
