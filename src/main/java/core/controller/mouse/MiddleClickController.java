package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.model.Structure;
import java.awt.Point;
import java.util.Optional;

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
