package core.service.session.update;

import core.App;
import core.lib.Service;
import core.model.Structure;
import core.session.Session;
import java.awt.Color;

@Service
public class SessionUpdater implements StructureUpdater, PropertiesUpdater {
    public void updateCurrentSessionColor(Color color) {
        App.getSession().getProperties().setCurrentColor(color);
    }

    public void updateChosenStructure(Color color) {
        Session session = App.getSession();
        Structure chosenStructure = session.getProperties().getChosenStructure();
        if (chosenStructure != null) {
            chosenStructure.setColor(color);
            session.getSceneControl().update();
        }
    }
}
