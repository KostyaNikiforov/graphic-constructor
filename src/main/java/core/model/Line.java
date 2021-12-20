package core.model;

import core.model.type.StructureType;
import java.awt.Point;

public class Line extends Structure {
    private static final int VISIBILITY_RADIUS = 10;

    public Line(Point centerPosition, Point startPosition, Point endPosition) {
        super(centerPosition, StructureType.LINE);
        relativePoints.put("start", startPosition);
        relativePoints.put("end", endPosition);
    }

    public Point getStartPosition() {
        return relativePoints.get("start");
    }

    public void setStartPosition(Point startPoint) {
        relativePoints.put("start", startPoint);
    }

    public Point getEndPosition() {
        return relativePoints.get("end");
    }

    public void setEndPosition(Point endPoint) {
        relativePoints.put("end", endPoint);
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) <= VISIBILITY_RADIUS;
    }
}
