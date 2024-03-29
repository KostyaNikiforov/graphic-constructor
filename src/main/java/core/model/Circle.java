package core.model;

import core.session.enums.CreatingMode;
import core.utils.MathFunctions;
import java.awt.Point;

public class Circle extends Structure {
    public Circle(Point centerPosition, Point radiusPoint) {
        super(centerPosition, CreatingMode.CIRCLE);
        relativePoints.put("radius", radiusPoint);
    }

    public int getRadius() {
        return (int) centerPosition.distance(relativePoints.get("radius"));
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
