package core.controller.mouse;

import java.awt.Point;
import java.util.Optional;
import core.App;
import core.controller.MouseController;
import core.model.Structure;
import core.session.Session;

public class LeftDoubleClickController implements MouseController {
    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        Structure structure = session.getProperties().getChosenStructure();
        if (structure != null) {
            if (structure.isInside(point)) {
                session.getSceneControl().getScene().getStructureControl().remove(structure);
            }
        } else {
            Optional<Structure> optionalStructure
                    = session.getSceneControl().getScene()
                        .getStructureControl().findStructureOnPosition(point);
            optionalStructure.ifPresent(value ->
                    session.getSceneControl().getScene().getStructureControl().remove(value));
        }
        App.getSession().getSceneControl().update();
    }
}
