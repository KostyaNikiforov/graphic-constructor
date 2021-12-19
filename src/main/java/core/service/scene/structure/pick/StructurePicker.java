package core.service.scene.structure.pick;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public interface StructurePicker {
    int squareSideSize = 6;

    void pickUp(Structure structure, Graphics2D graphics2D);

    default void drawPickSquare(Point[] keyPoints, Graphics2D graphics2D) {
        for (Point point : keyPoints) {
            graphics2D.drawRect(
                    (int) point.getX() - squareSideSize / 2,
                    (int) point.getY() - squareSideSize / 2,
                    squareSideSize,
                    squareSideSize
            );
        }
    }
}
