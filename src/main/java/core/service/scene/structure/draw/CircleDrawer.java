package core.service.scene.structure.draw;

import core.model.Circle;
import core.model.Structure;
import java.awt.Graphics2D;

public class CircleDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Circle circle = (Circle) structure;
        int radius = (int) circle.getRadius();
        g.drawOval(
                (int) (circle.getCenterPosition().getX() - radius),
                (int) (circle.getCenterPosition().getY() - radius),
                radius * 2,
                radius * 2
        );
    }
}
