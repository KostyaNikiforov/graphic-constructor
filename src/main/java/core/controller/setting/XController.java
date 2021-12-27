package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import core.service.scene.structure.control.StructureControl;
import core.service.scene.structure.control.StructurePositioner;
import java.awt.Point;

public class XController implements SettingController {
    private StructurePositioner structurePositioner
            = (StructurePositioner) App.serviceInjector.getInstance(StructureControl.class);

    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = Integer.parseInt(text);
        int y = structure.getCenterPosition().y;
        structurePositioner.moveStructureTo(structure, new Point(x, y));
    }
}
