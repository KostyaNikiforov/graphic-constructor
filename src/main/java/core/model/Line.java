package core.model;

import core.model.type.StructureType;
import java.awt.Point;

public class Line extends Structure {
    private Point relativeStartPosition;

    public Line(Point centerPosition, Point startPosition) {
        super(centerPosition, StructureType.LINE);
        this.relativeStartPosition = startPosition;
    }

    public Point getRelativeStartPosition() {
        return relativeStartPosition;
    }

    public void setRelativeStartPosition(Point relativeStartPosition) {
        this.relativeStartPosition = relativeStartPosition;
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) < 10;
    }
}
