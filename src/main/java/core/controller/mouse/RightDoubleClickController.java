package core.controller.mouse;

import java.awt.Point;
import java.util.Optional;
import core.App;
import core.controller.MouseController;
import core.model.Structure;
import core.service.convetrors.StructureToSettingComponents;
import core.service.convetrors.StructureToSettingComponentsImpl;
import core.session.Session;
import core.session.enums.CreatingMode;

public class RightDoubleClickController implements MouseController {
    private final StructureToSettingComponents structureToSettingComponents
            = new StructureToSettingComponentsImpl();

    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        Optional<Structure> optionalStructure = session.getSceneControl().getScene()
                .getStructureControl().findStructureOnPosition(point);
        if (optionalStructure.isPresent()) {
            session.getProperties().setMovingPoint(optionalStructure.get().getCenterPosition());
            session.getProperties().setCreatingMode(CreatingMode.MOVING);
            session.getProperties().setChosenStructure(optionalStructure.get());
            session.getMainWindow().getAutocompleteRightPanel()
                    .fillUp(structureToSettingComponents.convert(optionalStructure.get()));
            App.getSession().getMainWindow()
                    .getCloseableRightPanel().open();
        } else {
            App.getSession().getMainWindow()
                    .getCloseableRightPanel().close();
            App.getSession().getProperties().setChosenStructure(null);
        }
    }
}
