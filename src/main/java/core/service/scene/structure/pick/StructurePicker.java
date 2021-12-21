package core.service.scene.structure.pick;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public interface StructurePicker {
    int squareSideSize = 6;

    void pickUp(Structure structure, Graphics2D graphics2D);

    default void drawPickSquare(Structure structure, Graphics2D graphics2D) {
        for (Map.Entry<String, Point> entry : structure.getRelativePoints().entrySet()) {
            Point point = entry.getValue();
            graphics2D.drawRect(
                      point.x - squareSideSize / 2,
                     point.y - squareSideSize / 2,
                    squareSideSize,
                    squareSideSize
            );
        }
        Point centerPosition = structure.getCenterPosition();
        graphics2D.drawRect(
                centerPosition.x - squareSideSize / 2,
                centerPosition.y - squareSideSize / 2,
                squareSideSize,
                squareSideSize
        );
    }
}
