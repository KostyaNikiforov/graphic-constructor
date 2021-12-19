package core.model;

import java.awt.Point;
import core.model.types.StructureType;

public class Rect extends Structure {
    private int width;
    private int height;

    public Rect(Point centerPosition, int width, int height) {
        super(centerPosition,StructureType.RECT);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean isInside(Point position) {
        int halfW = width / 2;
        int halfH = height / 2;
        return centerPosition.getX() - halfW < position.getX()
                && centerPosition.getY() - halfH < position.getY()
                && centerPosition.getX() + halfW > position.getX()
                && centerPosition.getY() + halfH > position.getY();
    }
}
