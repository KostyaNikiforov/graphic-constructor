package core.service.scene.structure.draw;

import core.model.Line;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

public class LineDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Line line = (Line) structure;
        Point startPosition = MathFunctions
                .getAbsolutFromRelative(line.getCenterPosition(), line.getStartPosition());
        Point endPosition = MathFunctions
                .getAbsolutFromRelative(line.getCenterPosition(), line.getEndPosition());
        g.drawLine(
                (int) startPosition.getX(),
                (int) startPosition.getY(),
                (int) endPosition.getX(),
                (int) endPosition.getY()
        );
    }
}
