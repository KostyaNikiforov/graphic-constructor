package core.service.scene.structure.processing.pick;

import core.model.Structure;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public interface StructurePicker<T extends Structure> {
    int squareSideSize = 6;

    default void pickUp(T t, Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.setStroke(new BasicStroke(2));
        drawPickSquare(t, graphics2D);
    }

    default void drawPickSquare(T t, Graphics2D graphics2D) {
        for (Map.Entry<String, Point> entry : t.getRelativePoints().entrySet()) {
            Point point = entry.getValue();
            graphics2D.drawRect(
                      point.x - squareSideSize / 2,
                     point.y - squareSideSize / 2,
                    squareSideSize,
                    squareSideSize
            );
        }
        Point centerPosition = t.getCenterPosition();
        graphics2D.drawRect(
                centerPosition.x - squareSideSize / 2,
                centerPosition.y - squareSideSize / 2,
                squareSideSize,
                squareSideSize
        );
    }
}
