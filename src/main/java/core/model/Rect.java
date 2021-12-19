package core.model;

import core.model.type.StructureType;
import java.awt.Point;

public class Rect extends Structure {
    private Point startPoint;
    private Point endPoint;

    public Rect(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition,StructureType.RECT);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getWidth() {
        return (int) (endPoint.getX() - startPoint.getX());
    }

    public void setWidth(int width) {
        endPoint.setLocation(startPoint.getX() + width, endPoint.getY());
    }

    public int getHeight() {
        return (int) (endPoint.getY() - startPoint.getY());
    }

    public void setHeight(int height) {
        endPoint.setLocation(endPoint.getX(), startPoint.getY() + height);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean isInside(Point position) {
        return startPoint.getX() < position.getX()
                && startPoint.getY() < position.getY()
                && endPoint.getX() > position.getX()
                && endPoint.getY() > position.getY();
    }
}
