package core.service.scene.structure.center.updater;

import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;
import java.util.Map;

public class LineCenterUpdater implements CenterPointUpdater {
    @Override
    public void update(Structure structure) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        structure.getCenterPosition().setLocation(
                MathFunctions.getCenterPosition(
                        relativePoints.get("start"), relativePoints.get("end"))
        );
    }
}
