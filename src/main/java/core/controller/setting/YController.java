package core.controller.setting;

import java.awt.Point;
import core.App;
import core.controller.SettingController;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.control.StructureControl;
import core.service.scene.structure.control.StructurePositioner;

public class YController implements SettingController {
    private StructurePositioner structurePositioner
            = (StructurePositioner) App.serviceInjector.getInstance(StructureControl.class);


    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        int x = structure.getCenterPosition().x;
        int y = Integer.parseInt(text);
        structurePositioner.moveStructureTo(structure, new Point(x, y));
    }
}
