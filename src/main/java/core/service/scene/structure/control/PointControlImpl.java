package core.service.scene.structure.control;

import core.App;
import core.lib.Inject;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;
import java.awt.Point;
import java.util.Optional;

public class PointControlImpl implements StructureControl {
    @Inject
    private StructureContainer structureContainer;

    @Override
    public Optional<Structure> findStructureOnPosition(Point position) {
        for (Structure structure : structureContainer.getAllStructures()) {
            if (structure.isInside(position)) {
                return Optional.of(structure);
            }
        }
        return Optional.empty();
    }

    @Override
    public void moveTo(Point point) {
        Point basePoint = App.getSession().getProperties().getPickedUpPints()[1];
        if (basePoint != null) {
            basePoint.setLocation(point);
            App.getSession().getSceneControl().update();
        }
    }

    public void remove(Structure structure) {
        if (structure != null) {
            App.getSession().getSceneControl().getScene().getStructureContainer()
                    .getAllStructures().remove(structure);
            App.getSession().getProperties().setChosenStructure(null);
        }
    }

    @Override
    public StructureContainer getStructureContainer() {
        return structureContainer;
    }
}
