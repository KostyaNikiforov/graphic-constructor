package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Rect;
import core.model.Structure;

public class WidthController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        ((Rect) structure).setWidth(Integer.parseInt(text));
    }
}
