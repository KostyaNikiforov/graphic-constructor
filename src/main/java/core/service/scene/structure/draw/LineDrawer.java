package core.service.scene.structure.draw;

import java.awt.Graphics2D;
import java.awt.Point;
import core.model.Line;
import core.model.Structure;
import core.utils.MathFunctions;

public class LineDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Line line = (Line) structure;
        Point startPosition = new Point(
                (int) (line.getCenterPosition().getX() + line.getRelativeStartPosition().getX()),
                (int) (line.getCenterPosition().getY() + line.getRelativeStartPosition().getY())
        );
        Point endPosition = MathFunctions.getEgePositionOfLine(line.getCenterPosition(), startPosition);
        g.drawLine(
                (int) startPosition.getX(),
                (int) startPosition.getY(),
                (int) endPosition.getX(),
                (int) endPosition.getY()
        );
    }
}
