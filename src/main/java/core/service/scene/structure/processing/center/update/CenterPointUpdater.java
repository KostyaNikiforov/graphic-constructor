package core.service.scene.structure.processing.center.update;

import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;
import java.util.Map;

public interface CenterPointUpdater<T extends Structure> {
    default void updateCenter(Structure structure) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        structure.getCenterPosition().setLocation(
                MathFunctions.getCenterPosition(
                        relativePoints.get("start"), relativePoints.get("end"))
        );
    }
}
