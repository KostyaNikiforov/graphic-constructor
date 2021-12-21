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
                circle.getCenterPosition().x - radius,
                circle.getCenterPosition().y - radius,
                radius * 2,
                radius * 2
        );
    }
}
