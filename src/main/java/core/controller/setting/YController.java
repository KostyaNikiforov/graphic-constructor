package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import core.service.scene.structure.control.StructureControlImpl;
import core.service.scene.structure.control.StructurePositioner;
import java.awt.Point;

public class YController implements SettingController {
    private StructurePositioner structurePositioner
            = new StructureControlImpl();

    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = structure.getCenterPosition().x;
        int y = Integer.parseInt(text);
        structurePositioner.moveStructureTo(structure, new Point(x, y));
    }
}
