package zzc.ui.dialogs.AboutMod;

import arc.Core;
import arc.graphics.Color;
import arc.scene.ui.Dialog;
import arc.util.Http;
import arc.util.Strings;
import mindustry.gen.Icon;
import mindustry.io.JsonIO;
import mindustry.ui.dialogs.BaseDialog;
import zzc.AP;
import zzc.ui.APIcons;
import zzc.util.javaBean.UpdateBase;

import static arc.Core.app;
import static arc.Core.bundle;
import static mindustry.Vars.ghApi;
import static mindustry.Vars.ui;

public class ModChangelog extends BaseDialog {

    public ModChangelog() {
        super(bundle.get("dialog.modChangelog.name"));
    }

    public void build() {
        cont.clear();
        Http.get("https://raw.githubusercontent.com/lyrgo/AzurePlanetUpdate/blob/main/updata.json",response->{ //获取github上的更新日志
            String strResult = response.getResultAsString();//获取为字符串
            try{
                UpdateBase updateBase = JsonIO.json.fromJson(UpdateBase.class,strResult);//转为javaBean
                if(updateBase.version == AP.modVersion) { //当前已经是最新版本
                    app.post(()->ui.showText("modVersion(mod版本)",bundle.get("dialog.modVersion.new.name")));
                } else {
                    new Dialog() {{
                        cont.add("A new version has been detected\n检测到新版本");
                        cont.bottom();
                        cont.button("update(更新)",()->{ //同意更新 新版本

                        });
                        cont.button("@back",this::hide);
                    }}.show();
                }
//                cont.top().table(main -> {
//                    main.pane(menu -> {
//
//                    });
//                }).grow();
            } catch (Exception e) {
                e.printStackTrace();
                ui.showException(e);
            }
        },e-> {
            Core.app.post(() -> showError(e));
            cont.add("Module acquisition failed(模组获取失败)");
        });
        cont.row();
        cont.image().color(Color.white).growX().height(2).pad(0).padTop(4).row();
        cont.table(main->{
            main.button("github",Icon.github,()->{
                Core.app.openURI(AP.modGithub);
            }).size(125,75);
            main.button("QQ 1群", APIcons.qqIcon,()->{
                Core.app.openURI(AP.modQQ1);
            }).size(125,75);
            main.button("QQ 2群", APIcons.qqIcon,()->{
                Core.app.openURI(AP.modQQ2);
            }).size(125,75);
            main.button("@back",Icon.left,this::hide).size(125,75);
        }).growX().fillY().row();
    }

    private void showError(Throwable error){
        ui.loadfrag.hide();

        if(error instanceof NoSuchMethodError || Strings.getCauses(error).contains(t -> t.getMessage() != null && (t.getMessage().contains("trust anchor") || t.getMessage().contains("SSL") || t.getMessage().contains("protocol")))){
            ui.showErrorMessage("@feature.unsupported");
        }else if(error instanceof Http.HttpStatusException st){
            ui.showErrorMessage(Core.bundle.format("connectfail", Strings.capitalize(st.status.toString().toLowerCase())));
        }else{
            ui.showException(error);
        }
    }

    private void getModFromGithub(double version) {
        Http.get(ghApi + "/repos/lyrgo/AzurePlanetUpdate/releases/" + version,res->{

        },e->{

        });
    }
}
