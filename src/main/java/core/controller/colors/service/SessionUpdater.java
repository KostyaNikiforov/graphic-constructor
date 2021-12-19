package core.controller.colors.service;

import core.App;
import core.lib.Service;
import core.model.Structure;
import java.awt.Color;

@Service
public class SessionUpdater implements StructureUpdater, PropertiesUpdater {
    public void updateCurrentSessionColor(Color color) {
        App.getSession().getProperties().setCurrentColor(color);
    }

    public void updateChosenStructure(Color color) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        if (structure != null) {
            structure.setColor(color);
        }
        App.getSession().getSceneControl().update();
    }
}
