package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Circle;
import core.model.Structure;

public class RadiusController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        ((Circle) structure).setRadius(Integer.parseInt(text));
    }
}
