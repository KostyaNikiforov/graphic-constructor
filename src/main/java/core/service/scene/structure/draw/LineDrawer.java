package core.service.scene.structure.draw;

import java.awt.Graphics2D;
import java.awt.Point;
import core.model.Line;
import core.model.Structure;

public class LineDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Line line = (Line) structure;
        Point startPosition = line.getStartPosition();
        Point endPosition = line.getCenterPosition();
        g.drawLine(
                (int) startPosition.getX(),
                (int) startPosition.getY(),
                (int) endPosition.getX(),
                (int) endPosition.getY()
        );
    }
}
