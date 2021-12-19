package core.model;

import java.awt.Point;
import core.model.type.StructureType;

public class Circle extends Structure {
    private int radius;

    public Circle(Point centerPosition, int radius) {
        super(centerPosition, StructureType.CIRCLE);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) < radius;
    }
}
