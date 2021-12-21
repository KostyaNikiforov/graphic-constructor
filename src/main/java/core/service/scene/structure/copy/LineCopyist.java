package core.service.scene.structure.copy;

import java.awt.Point;
import java.util.Map;
import core.Config;
import core.model.Line;
import core.model.Structure;

public class LineCopyist implements StructureCopyist {
    @Override
    public Structure createCopy(Structure structure) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        Point centerPoint = structure.getCenterPosition();
        Point startPoint = relativePoints.get("start");
        Point endPoint = relativePoints.get("end");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Line line = new Line(
                new Point(centerPoint.x + shift, centerPoint.y + shift),
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        line.setColor(structure.getColor());
        line.setStroke(structure.getStroke());
        return line;
    }
}
