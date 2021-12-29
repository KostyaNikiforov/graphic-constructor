package core.model;

import core.session.enums.CreatingMode;
import java.awt.Color;
import java.awt.Point;

public class Layer extends Rect {
    public static final Color DEFAULT_COLOR = Color.WHITE;

    public Layer(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, startPoint, endPoint);
        setCreatingMode(CreatingMode.LAYER);
        setColor(Color.WHITE);
    }
}
