package core.model;

import java.awt.Point;
import core.model.types.StructureType;

public class Line extends Structure {
    private Point startPosition;

    public Line(Point centerPosition, Point startPosition) {
        super(centerPosition, StructureType.LINE);
        this.startPosition = startPosition;
    }

    public Point getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Point startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) < 10;
    }
}
