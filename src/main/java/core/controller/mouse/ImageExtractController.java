package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.service.image.create.ImageCreator;
import core.service.image.create.ImageCreatorImpl;
import core.session.Session;
import java.awt.Point;

public class ImageExtractController implements MouseController {
    private final ImageCreator imageCreator = new ImageCreatorImpl();

    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        session.getSceneControl().getScene().getDrawer().drawHighlightingRect(
                App.getSession().getProperties().getStartPoint(),
                point
        );
    }
}
