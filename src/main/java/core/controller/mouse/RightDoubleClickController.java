package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.gui.models.panels.right.DynamicToolsPanel;
import core.model.Structure;
import core.service.convetror.StructureToSettingComponents;
import core.service.convetror.StructureToSettingComponentsImpl;
import core.session.Properties;
import core.session.Session;
import core.session.enums.CreatingMode;
import java.awt.Point;
import java.util.Optional;

public class RightDoubleClickController implements MouseController {
    private final StructureToSettingComponents structureToSettingComponents
            = new StructureToSettingComponentsImpl();

    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        Optional<Structure> optionalStructure = session.getSceneControl().getScene()
                .getStructureControl().findStructureOnPosition(point);
        DynamicToolsPanel dynamicToolsPanel = session.getMainWindow().getDynamicToolsPanel();
        if (optionalStructure.isPresent()) {
            Properties properties = session.getProperties();
            properties.setCreatingMode(CreatingMode.MOVING);
            properties.setChosenStructure(optionalStructure.get());
            dynamicToolsPanel.fillUp(structureToSettingComponents.convert(optionalStructure.get()));
            dynamicToolsPanel.open();
            session.getSceneControl().update();
        } else {
            dynamicToolsPanel.close();
            session.getProperties().setChosenStructure(null);
        }
    }
}
