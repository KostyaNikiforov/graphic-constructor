package core.model;

import core.model.type.StructureType;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Structure implements Searchable, Cloneable {
    protected final Map<String, Point> relativePoints;
    protected Point centerPosition;
    protected Color color;
    protected int strokeWidth;
    private StructureType type;

    public Structure(Point centerPosition, StructureType type) {
        relativePoints = new HashMap<>();
        this.centerPosition = centerPosition;
        this.type = type;
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

    public StructureType getType() {
        return type;
    }

    protected void setType(StructureType type) {
        this.type = type;
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
