package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.session.Session;
import java.awt.Point;

public class HighlightingController implements MouseController {
    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        session.getSceneControl().getScene().getDrawer()
                .drawHighlightingRect(
                        session.getProperties().getStartPoint(),
                        point
        );
    }
}
