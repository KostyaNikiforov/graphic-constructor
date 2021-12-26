package core.model;

import java.awt.Point;
import core.Config;
import core.model.type.StructureType;

public class Text extends Structure {
    private String content;
    private int size;

    public Text(Point centerPosition, int size) {
        super(centerPosition, StructureType.TEXT);
        this.size = size;
    }

    @Override
    public boolean isInside(Point point) {
        return centerPosition.distance(point) > Config.TEXT_VISIBILITY_RADIUS;
    }
}
