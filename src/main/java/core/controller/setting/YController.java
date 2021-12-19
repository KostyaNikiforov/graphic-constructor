package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import java.awt.Point;

public class YController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = (int) structure.getCenterPosition().getX();
        int y = Integer.parseInt(text);
        structure.setCenterPosition(new Point(x, y));
    }
}
