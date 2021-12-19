package core.service.create.strategy.creators;

import core.App;
import core.model.Line;
import core.utils.MathFunctions;
import java.awt.Point;

public class LineCreator implements StructureCreator {
    @Override
    public Line create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Point relativeStartPosition = new Point(
                (int) (startPosition.getX() - centerPosition.getX()),
                (int) (startPosition.getY() - centerPosition.getY())
        );
        Line line = new Line(centerPosition, relativeStartPosition);
        line.setColor(App.getSession().getProperties().getCurrentColor());
        line.setStroke(App.getSession().getProperties().getCurrentStroke());
        return line;
    }
}
