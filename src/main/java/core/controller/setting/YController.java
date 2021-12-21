package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;

public class YController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = structure.getCenterPosition().x;
        int y = Integer.parseInt(text);
        structure.getCenterPosition().setLocation(x, y);
    }
}
