package core.service.create.strategy.creators;

import java.awt.Point;
import core.App;
import core.model.Circle;
import core.model.Structure;

public class CircleCreator implements StructureCreator {
    @Override
    public Structure create(Point startPosition, Point endPosition) {
        int radius = (int) startPosition.distance(endPosition);
        Structure circle = new Circle(startPosition, radius);
        circle.setColor(App.getSession().getProperties().getCurrentColor());
        circle.setStroke(App.getSession().getProperties().getCurrentStroke());
        return circle;
    }
}
