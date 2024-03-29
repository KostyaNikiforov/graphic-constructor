package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import core.model.Text;

public class TextContentController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        ((Text) structure).setContent(text);
    }
}
