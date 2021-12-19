package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import java.awt.Point;

public class XController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = Integer.parseInt(text);
        int y = (int) structure.getCenterPosition().getY();
        structure.setCenterPosition(new Point(x, y));
    }
}
