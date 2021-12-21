package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.model.Structure;
import java.awt.Point;

public class StructureMovingController implements MouseController {
    @Override
    public void apply(Point point) {
        Structure chosenStructure = App.getSession().getProperties().getChosenStructure();
        if (chosenStructure != null) {
            App.getSession().getSceneControl().getScene()
                    .getStructureControl().modify(chosenStructure, point);
        }
    }

}
