package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import java.awt.Point;

public class MouseMovingController implements MouseController {
    @Override
    public void apply(Point point) {
        App.getSession().getMainWindow()
                .getMousePositionInfoContainer().updateMousePosition(point);
    }
}
