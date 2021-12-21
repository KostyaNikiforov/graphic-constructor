package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.model.Structure;
import core.service.scene.structure.copy.strategy.StructureCopyStrategy;
import core.session.Session;
import java.awt.Point;
import java.util.Optional;

public class MiddleClickController implements MouseController {
    private StructureCopyStrategy structureCopyStrategy
            = (StructureCopyStrategy) App.serviceInjector.getInstance(StructureCopyStrategy.class);

    @Override
    public void apply(Point point) {
        Session session = App.getSession();
        Structure chosenStructure = session.getProperties().getChosenStructure();
        if (chosenStructure != null) {
            makeCopy(session, chosenStructure);
        } else {
            Optional<Structure> optionalStructure = App.getSession().getSceneControl().getScene()
                    .getStructureControl().findStructureOnPosition(point);
            optionalStructure.ifPresent(s -> makeCopy(session, s));
        }
        session.getSceneControl().update();
    }

    private void makeCopy(Session session, Structure structure) {
        session.getSceneControl().getScene()
                .getStructureContainer().add(structureCopyStrategy
                        .getStructureCopyist(structure.getType()).createCopy(structure)
        );
    }
}
