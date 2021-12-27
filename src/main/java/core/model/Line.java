package core.model;

import core.session.enums.CreatingMode;
import java.awt.Point;

public class Line extends Structure {
    private static final int VISIBILITY_RADIUS = 10;

    public Line(Point centerPosition, Point startPosition, Point endPosition) {
        super(centerPosition, CreatingMode.LINE);
        relativePoints.put("start", startPosition);
        relativePoints.put("end", endPosition);
    }

    public int getLength() {
        return (int) relativePoints.get("start").distance(relativePoints.get("end"));
    }

    @Override
    public boolean isInside(Point position) {
        return position.distance(centerPosition) <= VISIBILITY_RADIUS;
    }
}
