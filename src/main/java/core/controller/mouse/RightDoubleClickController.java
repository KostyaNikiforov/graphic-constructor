package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.model.Structure;
import core.service.convetror.StructureToSettingComponents;
import core.service.convetror.StructureToSettingComponentsImpl;
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
        if (optionalStructure.isPresent()) {
            session.getProperties().setCreatingMode(CreatingMode.MOVING);
            session.getProperties().setChosenStructure(optionalStructure.get());
            session.getMainWindow().getAutocompleteRightPanel()
                    .fillUp(structureToSettingComponents.convert(optionalStructure.get()));
            session.getMainWindow()
                    .getCloseableRightPanel().open();
            session.getSceneControl().update();
        } else {
            session.getMainWindow()
                    .getCloseableRightPanel().close();
            session.getProperties().setChosenStructure(null);
        }
    }
}
