package core.model;

import core.model.type.StructureType;
import java.awt.Point;

public class Rect extends Structure {
    public Rect(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, StructureType.RECT);
        relativePoints.put("start", startPoint);
        relativePoints.put("end", endPoint);
    }

    public int getWidth() {
        return relativePoints.get("end").x - relativePoints.get("start").x;
    }

    public void setWidth(int width) {

    }

    public int getHeight() {
        return relativePoints.get("end").y - relativePoints.get("start").y;
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
        return relativePoints.get("start").x < position.getX()
                && relativePoints.get("start").y < position.getY()
                && relativePoints.get("end").x > position.getX()
                && relativePoints.get("end").y > position.getY();
    }
}
