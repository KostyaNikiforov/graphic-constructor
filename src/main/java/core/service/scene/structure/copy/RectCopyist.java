package core.service.scene.structure.copy;

import java.awt.Point;
import java.util.Map;
import core.Config;
import core.model.Rect;
import core.model.Structure;

public class RectCopyist implements StructureCopyist {
    @Override
    public Structure createCopy(Structure structure) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        Point centerPoint = structure.getCenterPosition();
        Point startPoint = relativePoints.get("start");
        Point endPoint = relativePoints.get("end");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Rect rect = new Rect(
                new Point(centerPoint.x + shift, centerPoint.y + shift),
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        rect.setColor(structure.getColor());
        rect.setStroke(structure.getStroke());
        return rect;
    }
}
