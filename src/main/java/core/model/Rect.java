package core.model;

import core.model.type.StructureType;
import core.utils.MathFunctions;
import java.awt.Point;

public class Rect extends Structure {
    public Rect(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, StructureType.RECT);
        relativePoints.put("start", startPoint);
        relativePoints.put("end", endPoint);
    }

    public int getWidth() {
        Point startPoint = MathFunctions.getAbsolutFromRelative(centerPosition, relativePoints.get("start"));
        Point endPoint = MathFunctions.getAbsolutFromRelative(centerPosition, relativePoints.get("end"));
        return endPoint.x - startPoint.x;
    }

    public void setWidth(int width) {

    }

    public int getHeight() {
        Point startPoint = MathFunctions.getAbsolutFromRelative(centerPosition, relativePoints.get("start"));
        Point endPoint = MathFunctions.getAbsolutFromRelative(centerPosition, relativePoints.get("end"));
        return endPoint.y - startPoint.y;
    }

    public void setHeight(int height) {
    }

    public Point getStartPoint() {
        return relativePoints.get("start");
    }

    public void setStartPoint(Point startPoint) {
        relativePoints.put("start", startPoint);
    }

    public Point getEndPoint() {
        return relativePoints.get("end");
    }

    public void setEndPoint(Point endPoint) {
        relativePoints.put("end", endPoint);
    }

    @Override
    public boolean isInside(Point position) {
        Point absoluteStartPoint = MathFunctions
                .getAbsolutFromRelative(centerPosition, getStartPoint());
        Point absoluteEndPoint = MathFunctions
                .getAbsolutFromRelative(centerPosition, getEndPoint());
        return absoluteStartPoint.getX() < position.getX()
                && absoluteStartPoint.getY() < position.getY()
                && absoluteEndPoint.getX() > position.getX()
                && absoluteEndPoint.getY() > position.getY();
    }
}
