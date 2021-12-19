package core.service.scene.structure.pick;

import java.awt.Graphics2D;
import java.awt.Point;
import core.model.Line;
import core.model.Structure;
import core.utils.MathFunctions;

public class LinePicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Line line = (Line) structure;
        Point startPosition = new Point(
                (int) (line.getCenterPosition().getX() + line.getRelativeStartPosition().getX()),
                (int) (line.getCenterPosition().getY() + line.getRelativeStartPosition().getY())
        );
        Point endPosition = MathFunctions.getEgePositionOfLine(line.getCenterPosition(), startPosition);
        drawPickSquare(new Point[] {startPosition, line.getCenterPosition(), endPosition}, graphics2D);
    }
}
