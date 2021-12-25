package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.gui.models.panels.right.DynamicToolsPanel;
import core.model.Structure;
import core.session.Session;
import java.awt.Point;
import java.util.Optional;

public class RightDoubleClickController implements MouseController {

    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        Optional<Structure> optionalStructure = session.getSceneControl().getScene()
                .getStructureControl().findStructureOnPosition(point);
        DynamicToolsPanel dynamicToolsPanel = session.getMainWindow().getDynamicToolsPanel();
        if (optionalStructure.isPresent()) {
            session.getSceneControl().getScene()
                    .getStructureControl().chooseStructure(optionalStructure.get());
        } else {
            dynamicToolsPanel.close();
            session.getProperties().setChosenStructure(null);
        }
    }
}
