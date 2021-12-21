package core.service.scene.structure.copy;

import core.App;
import core.Config;
import core.model.Structure;
import core.service.scene.structure.create.strategy.StructureCreateStrategy;
import java.awt.Point;
import java.util.Map;

public class LineRectCopyist implements StructureCopyist {
    private StructureCreateStrategy structureCreateStrategy = (StructureCreateStrategy)
            App.serviceInjector.getInstance(StructureCreateStrategy.class);

    @Override
    public Structure createCopy(Structure structure) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        Point startPoint = relativePoints.get("start");
        Point endPoint = relativePoints.get("end");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        return structureCreateStrategy
                .getStructureCreator(structure.getType().getCreatingMode())
                .create(
                        new Point(startPoint.x + shift, startPoint.y + shift),
                        new Point(endPoint.x + shift, endPoint.y + shift)
                );
    }
}
