package core.service.scene.structure.pick;

import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public interface StructurePicker {
    int squareSideSize = 6;

    void pickUp(Structure structure, Graphics2D graphics2D);

    default void drawPickSquare(Structure structure, Graphics2D graphics2D) {
        for (Map.Entry<String, Point> entry : structure.getRelativePoints().entrySet()) {
            Point absolutePoint = MathFunctions
                    .getAbsolutFromRelative(structure.getCenterPosition(), entry.getValue());
            graphics2D.drawRect(
                      absolutePoint.x - squareSideSize / 2,
                     absolutePoint.y - squareSideSize / 2,
                    squareSideSize,
                    squareSideSize
            );
        }
        graphics2D.drawRect(
                structure.getCenterPosition().x - squareSideSize / 2,
                structure.getCenterPosition().y - squareSideSize / 2,
                squareSideSize,
                squareSideSize
        );
    }
}
