package core.service.scene.structure.draw;

import java.awt.Graphics2D;
import core.model.Circle;
import core.model.Structure;

public class CircleDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Circle circle = (Circle) structure;
        g.drawOval(
                (int) (circle.getCenterPosition().getX() - circle.getRadius()),
                (int) (circle.getCenterPosition().getY() - circle.getRadius()),
                (int) circle.getRadius() * 2,
                (int) circle.getRadius() * 2
        );
    }
}
