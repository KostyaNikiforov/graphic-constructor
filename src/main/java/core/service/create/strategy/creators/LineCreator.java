package core.service.create.strategy.creators;

import java.awt.Point;
import core.App;
import core.model.Line;

public class LineCreator implements StructureCreator {
    @Override
    public Line create(Point startPosition, Point endPosition) {
        Line line = new Line(endPosition, startPosition);
        line.setColor(App.getSession().getProperties().getCurrentColor());
        line.setStroke(App.getSession().getProperties().getCurrentStroke());
        return line;
    }
}
