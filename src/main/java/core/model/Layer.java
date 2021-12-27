package core.model;

import core.session.enums.CreatingMode;
import java.awt.Point;

public class Layer extends Rect {
    public Layer(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, startPoint, endPoint);
        setCreatingMode(CreatingMode.LAYER);
    }
}
