package core.model;

import core.model.type.StructureType;
import core.utils.MathFunctions;
import java.awt.Point;

public class Circle extends Structure {
    public Circle(Point centerPosition, Point radiusPoint) {
        super(centerPosition, StructureType.CIRCLE);
        relativePoints.put("radius", radiusPoint);
    }

    public double getRadius() {
        return centerPosition.distance(relativePoints.get("radius"));
    }

    public void setRadius(int radius) {
        relativePoints.put("radius",
                MathFunctions.getPositionByAngleAndDistance(centerPosition, radius, 0)
        );
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) < getRadius();
    }
}
