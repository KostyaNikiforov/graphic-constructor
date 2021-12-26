package core.service.scene.structure.control;

import core.App;
import core.gui.models.panels.right.DynamicToolsPanel;
import core.lib.Inject;
import core.lib.Service;
import core.model.Structure;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.center.updater.strategy.CenterUpdateStrategy;
import core.session.Properties;
import core.session.Session;
import core.session.enums.CreatingMode;
import java.awt.Point;
import java.util.List;
import java.util.ListIterator;
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
        List<Structure> list = structureContainer.getAllStructures();
        ListIterator<Structure> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Structure structure = listIterator.previous();
            if (structure.isInside(position)) {
                return Optional.of(structure);
            }
        }
        return Optional.empty();
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
    public void updateContainer(StructureContainer version) {
        structureContainer = version;
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

    @Override
    public void chooseStructure(Structure structure) {
        Session session = App.getSession();
        DynamicToolsPanel dynamicToolsPanel = session.getMainWindow().getDynamicToolsPanel();
        Properties properties = session.getProperties();
        properties.setCreatingMode(CreatingMode.MOVING);
        properties.setChosenStructure(structure);
        dynamicToolsPanel.fillUp(structureToSettingComponents.convert(structure));
        dynamicToolsPanel.open();
        session.getSceneControl().update();
        raiseStructureInContainer(structure);
    }

    private void raiseStructureInContainer(Structure structure) {
        List<Structure> allStructures = structureContainer.getAllStructures();
        allStructures.remove(structure);
        allStructures.add(structure);
    }
}
