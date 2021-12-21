package core.service.scene.structure.copy;

import core.App;
import core.Config;
import core.model.Structure;
import core.service.scene.structure.create.strategy.StructureCreateStrategy;
import java.awt.Point;

public class CircleCopyist implements StructureCopyist {
    private StructureCreateStrategy structureCreateStrategy = (StructureCreateStrategy)
            App.serviceInjector.getInstance(StructureCreateStrategy.class);

    @Override
    public Structure createCopy(Structure structure) {
        Point startPoint = structure.getCenterPosition();
        Point endPoint = structure.getRelativePoints().get("radius");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        return structureCreateStrategy
                .getStructureCreator(structure.getType().getCreatingMode())
                .create(
                        new Point(startPoint.x + shift, startPoint.y + shift),
                        new Point(endPoint.x + shift, endPoint.y + shift)
                );
    }
}
