package core.service.scene.structure.copy;

import core.Config;
import core.model.Circle;
import core.model.Structure;
import java.awt.Point;

public class CircleCopyist implements StructureCopyist {
    @Override
    public Structure createCopy(Structure structure) {
        Point startPoint = structure.getCenterPosition();
        Point endPoint = structure.getRelativePoints().get("radius");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Circle circle = new Circle(
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        circle.setColor(structure.getColor());
        circle.setStroke(structure.getStroke());
        return circle;
    }
}
