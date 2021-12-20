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
        return Math.abs(relativePoints.get("start").x) * 2;
    }

    public void setWidth(int width) {

    }

    public int getHeight() {
        return Math.abs(relativePoints.get("start").y) * 2;
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
