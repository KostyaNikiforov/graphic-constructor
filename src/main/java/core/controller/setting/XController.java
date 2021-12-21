package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;

public class XController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = Integer.parseInt(text);
        int y = structure.getCenterPosition().y;
        structure.getCenterPosition().setLocation(x, y);
    }
}
