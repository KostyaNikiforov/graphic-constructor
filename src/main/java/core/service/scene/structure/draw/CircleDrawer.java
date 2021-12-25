package core.service.scene.structure.draw;

import core.model.Circle;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

public class CircleDrawer implements StructureDrawer, RelativeStructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Circle circle = (Circle) structure;
        drawCircle(g, circle, circle.getCenterPosition());
    }

    @Override
    public void draw(Structure structure, Graphics2D g, Point basePoint) {
        Circle circle = (Circle) structure;
        Point centerPoint
                = MathFunctions.getRelativeFromAbsolute(basePoint, circle.getCenterPosition());
        drawCircle(g, circle, centerPoint);
    }

    private void drawCircle(Graphics2D g, Circle circle, Point centerPoint) {
        initGraphic(g, circle);
        int radius = (int) circle.getRadius();
        g.drawOval(
                centerPoint.x - radius,
                centerPoint.y - radius,
                radius * 2,
                radius * 2
        );
    }
}
