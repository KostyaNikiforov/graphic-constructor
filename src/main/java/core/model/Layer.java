package core.model;

import core.model.type.StructureType;
import java.awt.Point;

public class Layer extends Rect {
    public Layer(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, startPoint, endPoint);
        setType(StructureType.LAYER);
    }
}
