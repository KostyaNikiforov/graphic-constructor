package core.controller.mouse;

import java.awt.Point;
import java.util.Optional;
import core.App;
import core.controller.MouseController;
import core.model.Structure;

public class MiddleClickController implements MouseController {
    @Override
    public void apply(Point point) {
        Optional<Structure> optionalStructure
                = App.getSession().getSceneControl().getScene()
                        .getStructureControl().findStructureOnPosition(point);
        optionalStructure.ifPresent(structure ->
                App.getSession().getSceneControl().getScene()
                        .getStructureContainer().add((Structure) structure.clone()));
        App.getSession().getSceneControl().update();
    }
}
