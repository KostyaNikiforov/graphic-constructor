package core.model;

import java.awt.Color;
import java.awt.Point;
import core.model.type.StructureType;

public abstract class Structure implements Cloneable, Searchable {
    public final StructureType type;
    protected Point centerPosition;
    protected Color color;
    protected int stroke;

    public Structure(Point centerPosition, StructureType type) {
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

    @Override
    public String toString() {
        return type.toString();
    }

    @Override
    public Object clone() {
        try {
            Structure structure = (Structure) super.clone();
            structure.setCenterPosition(new Point((int) this.getCenterPosition().getX() + 25,
                    (int) this.getCenterPosition().getY() + 25));
            return structure;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cannot clone object: " + this, e);
        }
    }
}
