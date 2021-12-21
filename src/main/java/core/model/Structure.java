package core.model;

import core.model.type.StructureType;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Structure implements Searchable {
    protected Point centerPosition;
    protected Color color;
    protected int stroke;
    protected final Map<String, Point> relativePoints;
    private final StructureType type;

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

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
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

    public Map<String, Point> getRelativePoints() {
        return relativePoints;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
