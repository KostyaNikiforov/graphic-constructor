package core.controller.mouse;

import java.awt.Point;
import core.App;
import core.controller.MouseController;

public class RightPressController implements MouseController {
    @Override
    public void apply(Point point) {
        App.getSession().getProperties().setStartPoint(point);
    }
}
