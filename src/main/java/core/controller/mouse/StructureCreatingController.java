package core.controller.mouse;

import java.awt.Point;
import core.App;
import core.controller.MouseController;
import core.session.Session;

public class StructureCreatingController implements MouseController {
    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        session.getSceneControl().getScene().getDrawer()
                .drawCreatingStructure(session.getProperties().getStartPoint(), point);
    }
}
