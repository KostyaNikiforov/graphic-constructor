package core.service.scene.structure.control;

import java.awt.Point;
import java.util.Optional;
import core.App;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;

public class StructureControlImpl implements StructureControl {
    private StructureContainer structureContainer;

    public StructureControlImpl(StructureContainer structureContainer) {
        this.structureContainer = structureContainer;
    }

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
        Structure structure = App.getSession().getProperties().getChosenStructure();
        if (structure != null) {
            structure.setCenterPosition(point);
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
}
