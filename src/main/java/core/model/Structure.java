package core.model;

import core.session.enums.CreatingMode;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Structure implements Searchable, Cloneable {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    protected final Map<String, Point> relativePoints;
    protected Point centerPosition;
    protected Color color;
    protected int strokeWidth;
    private CreatingMode creatingMode;

    public Structure(Point centerPosition, CreatingMode creatingMode) {
        this(centerPosition, creatingMode, DEFAULT_COLOR);
    }

    public Structure(Point centerPosition, CreatingMode creatingMode, Color defaultColor) {
        relativePoints = new HashMap<>();
        this.color = defaultColor;
        this.centerPosition = centerPosition;
        this.creatingMode = creatingMode;
    }

    public Point getCenterPosition() {
        return centerPosition;
    }

    public void setCenterPosition(Point centerPosition) {
        this.centerPosition = centerPosition;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int width) {
        this.strokeWidth = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CreatingMode getCreatingMode() {
        return creatingMode;
    }

    protected void setCreatingMode(CreatingMode creatingMode) {
        this.creatingMode = creatingMode;
    }

    public Map<String, Point> getRelativePoints() {
        return relativePoints;
    }

    @Override
    public Structure clone() {
        try {
            Structure clone = (Structure) super.clone();
            clone.centerPosition = (Point) centerPosition.clone();
            for (Map.Entry<String, Point> entry : relativePoints.entrySet()) {
                clone.relativePoints.put(entry.getKey(), (Point) entry.getValue().clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
