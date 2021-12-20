package core.service.scene.structure.create;

import core.App;
import core.model.Circle;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;

public class CircleCreator implements StructureCreator {
    @Override
    public Structure create(Point startPosition, Point endPosition) {
        Structure circle = new Circle(
                startPosition,
                MathFunctions.getRelativeFromAbsolute(startPosition, endPosition)
        );
        circle.setColor(App.getSession().getProperties().getCurrentColor());
        circle.setStroke(App.getSession().getProperties().getCurrentStroke());
        return circle;
    }
}
