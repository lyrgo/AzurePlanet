package zzc.ui.dialogs.AboutMod;

import arc.Core;
import arc.func.Prov;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.scene.Element;
import arc.scene.style.Drawable;
import arc.scene.ui.Label;
import arc.scene.ui.layout.Scl;
import arc.util.Tmp;
import mindustry.gen.Tex;
import mindustry.graphics.Pal;
import mindustry.ui.WarningBar;
import mindustry.ui.dialogs.BaseDialog;
import zzc.AP;
import zzc.ui.APIcons;
import zzc.ui.APStyles;

import static arc.Core.bundle;

public class MainMenu extends BaseDialog {

    private boolean ifStart = true;

    public ButtonEntry[] buttonEntries = new ButtonEntry[]{
            new ButtonEntry(APIcons.startIcon,
                    () -> Core.bundle.get(ifStart? "dialog.startGame.name": "dialog.backToGame.name"),
                    () -> Color.white,
                    () -> {hide(); ifStart = false;})
            };

    public MainMenu() {
        super(bundle.get("dialog.mainMenu.name"));
    }

    public void build() {
        cont.clear();
        cont.top().table(main->{
            main.image(AP.modLogo).size(650,200).padTop(30);
            main.row();
            main.image().color(Pal.accent).growX().height(3).pad(0).padTop(4).padBottom(4);
            main.row();
            main.add(new WarningBar()).growX().height(14).color(Color.lightGray).padBottom(30).padLeft(-5).padRight(-5);
            main.row();
            main.add("A Z U R E P L A N E T").get().setFontScale(2);
            main.row();
            main.add(new WarningBar()).growX().height(14).color(Color.lightGray).padTop(30).padLeft(-5).padRight(-5);
            main.row();
            main.image().color(Pal.accent).growX().height(3).pad(0).padTop(4);
            main.row();

            main.pane(menu -> {
                menu.defaults().pad(0).padTop(6).margin(0).width(680).height(64).top();
                for(ButtonEntry entry : buttonEntries){
                    menu.button(b -> {
                        b.table(Tex.buttonEdge3, i -> i.image(entry.icon).size(55)).size(64);
                        Label l = b.add("").width(550).padLeft(10).get();
                        shown(() -> l.setText(entry.text.get()));

                        b.add(new Element(){
                            @Override
                            public void draw(){
                                Draw.color(Tmp.c1.set(entry.color.get()).lerp(Color.black, 0.3f));
                                Draw.alpha(parentAlpha);
                                Fill.square(x + width/2, y + height/2 - Scl.scl(6), width/8, 45);
                                Draw.color(entry.color.get());
                                Draw.alpha(parentAlpha);
                                Fill.square(x + width/2, y + height/2, width/8, 45);
                            }
                        }).size(64);
                    }, APStyles.underline, entry.run);
                    menu.row();
                }
            }).grow();
        }).growX().top().pad(0).margin(0);

        row();
        image().color(Color.white).growX().height(2).pad(0).padTop(4);
        row();
        table(t -> {
            t.add(AP.modDisplayName + AP.modVersion).left().padLeft(3);
            t.image().color(Color.white).growY().width(2).pad(0).margin(0).padLeft(4).colspan(4);
            t.add().growX();
        }).growX();
    }

    private static class ButtonEntry {
        public Drawable icon;//图片
        public Prov<String> text;//字
        public Prov<Color> color;//颜色
        public Runnable run;//被点击时

        private ButtonEntry(Drawable icon, Prov<String> text, Prov<Color> color, Runnable run) {
            this.icon = icon;
            this.text = text;
            this.color = color;
            this.run = run;
        }

        public ButtonEntry(Drawable icon, String text, Color color, Runnable run) {
            this(icon, () -> text, () -> color, run);
        }
    }
}
