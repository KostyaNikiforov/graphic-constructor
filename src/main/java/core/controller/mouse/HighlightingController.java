package core.controller.mouse;

import java.awt.Point;
import core.App;
import core.controller.MouseController;
import core.session.Session;

public class HighlightingController implements MouseController {
    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        App.getSession().getSceneControl().getScene().getDrawer()
                .drawHighlightingRect(
                        session.getProperties().getStartPoint(),
                        point
                );
    }
}
