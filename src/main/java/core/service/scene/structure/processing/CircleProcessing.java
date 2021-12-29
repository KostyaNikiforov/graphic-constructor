package core.service.scene.structure.processing;

import core.App;
import core.Config;
import core.lib.Service;
import core.model.Circle;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

@Service
public class CircleProcessing implements StructureProcessing<Circle> {
    @Override
    public Circle create(Point startPosition, Point endPosition) {
        Circle circle = new Circle(
                startPosition,
                endPosition
        );
        circle.setColor(circle.getColor());
        circle.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return circle;
    }

    @Override
    public void relativeDraw(Circle circle, Graphics2D g, Point basePoint) {
        Point centerPoint
                = MathFunctions.getRelativeFromAbsolute(basePoint, circle.getCenterPosition());
        drawCircle(g, circle, centerPoint);
    }

    @Override
    public void draw(Circle circle, Graphics2D g) {
        drawCircle(g, circle, circle.getCenterPosition());
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

    @Override
    public void updateCenter(Structure structure) {
    }

    @Override
    public Structure createCopy(Circle circle) {
        Point startPoint = circle.getCenterPosition();
        Point endPoint = circle.getRelativePoints().get("radius");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Circle newCircle = new Circle(
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        newCircle.setColor(circle.getColor());
        newCircle.setStrokeWidth(circle.getStrokeWidth());
        return newCircle;
    }
}
