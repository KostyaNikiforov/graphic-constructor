package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;

public class StrokeController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        structure.setStroke(Integer.parseInt(text));
    }
}
