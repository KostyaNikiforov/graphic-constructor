package core.service.scene.structure.control;

import core.App;
import core.lib.Inject;
import core.lib.Service;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;
import core.utils.MathFunctions;
import java.awt.Point;
import java.util.Map;
import java.util.Optional;

@Service
public class StructureControlImpl implements StructureControl {
    @Inject
    private StructureContainer structureContainer;

    @Override
    public Optional<Structure> findStructureOnPosition(Point position) {
        return structureContainer.getAllStructures().stream()
                .filter(x -> x.isInside(position))
                .findFirst();
    }

    @Override
    public void moveTo(Point point) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        if (structure != null) {
            structure.setCenterPosition(point);
            App.getSession().getSceneControl().update();
        }
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
        Point centerPoint = structure.getCenterPosition();
        Optional<Point> optionalPoint = searchForClosestRelativePoint(relativePoints, centerPoint, movedPoint);
        if (optionalPoint.isPresent()) {
            optionalPoint.get().setLocation(MathFunctions.getRelativeFromAbsolute(centerPoint, movedPoint));
        } else {
            centerPoint.setLocation(movedPoint);
        }
        App.getSession().getSceneControl().update();
    }

    private Optional<Point> searchForClosestRelativePoint(Map<String, Point> relativePoints, Point centerPoint, Point point) {
        for (Map.Entry<String, Point> entry : relativePoints.entrySet()) {
            if (point.distance(MathFunctions.getAbsolutFromRelative(centerPoint, entry.getValue())) <= VISIBILITY_RADIUS) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
}
