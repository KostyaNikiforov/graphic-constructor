package core.model;

import core.service.scene.structure.processing.RectProcessing;
import core.session.enums.CreatingMode;
import java.awt.Point;

public class Rect extends Structure {
    public Rect(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, CreatingMode.RECT);
        relativePoints.put("start", startPoint);
        relativePoints.put("end", endPoint);
    }

    public int getWidth() {
        return relativePoints.get("end").x - relativePoints.get("start").x;
    }

    public void setWidth(int width) {
        Point start = relativePoints.get("start");
        relativePoints.get("end").setLocation(start.x + width, relativePoints.get("end").y);
        new RectProcessing().updateCenter(this);
    }

    public int getHeight() {
        return relativePoints.get("end").y - relativePoints.get("start").y;
    }

    public void setHeight(int height) {
        Point start = relativePoints.get("start");
        relativePoints.get("end").setLocation(relativePoints.get("end").x, start.y + height);
        new RectProcessing().updateCenter(this);
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
