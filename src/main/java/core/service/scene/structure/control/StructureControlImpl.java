package core.service.scene.structure.control;

import core.App;
import core.lib.Inject;
import core.lib.Service;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.center.updater.strategy.CenterUpdateStrategy;
import java.awt.Point;
import java.util.Map;
import java.util.Optional;

@Service
public class StructureControlImpl implements StructureControl {
    @Inject
    private StructureContainer structureContainer;
    @Inject
    private CenterUpdateStrategy centerUpdateStrategy;

    @Override
    public Optional<Structure> findStructureOnPosition(Point position) {
        return structureContainer.getAllStructures().stream()
                .filter(x -> x.isInside(position))
                .findFirst();
    }

    @Override
    public void moveStructureTo(Structure structure, Point point) {
        Point centerPosition = structure.getCenterPosition();
        int difX = point.x - centerPosition.x;
        int difY = point.y - centerPosition.y;
        for (Map.Entry<String, Point> entry : structure.getRelativePoints().entrySet()) {
            entry.getValue().translate(difX, difY);
        }
        centerPosition.setLocation(point);
        App.getSession().getSceneControl().update();
    }

    @Override
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

    @Override
    public void modify(Structure structure, Point movedPoint) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        Optional<Point> optionalPoint
                = searchForClosestRelativePoint(relativePoints, movedPoint);
        if (optionalPoint.isPresent()) {
            updateRelativePoint(structure, optionalPoint.get(), movedPoint);
        } else {
            moveStructureTo(structure, movedPoint);
        }
    }

    private Optional<Point> searchForClosestRelativePoint(
            Map<String, Point> relativePoints, Point point) {
        for (Map.Entry<String, Point> entry : relativePoints.entrySet()) {
            if (point.distance(entry.getValue()) <= VISIBILITY_RADIUS) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    private void updateRelativePoint(Structure structure, Point relativePoint, Point newPoint) {
        relativePoint.setLocation(newPoint);
        centerUpdateStrategy.getCenterPointUpdater(structure.getType()).update(structure);
        App.getSession().getSceneControl().update();
    }
}
