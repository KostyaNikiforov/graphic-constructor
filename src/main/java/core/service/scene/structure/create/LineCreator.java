package core.service.scene.structure.create;

import core.App;
import core.model.Line;
import core.utils.MathFunctions;
import java.awt.Point;

public class LineCreator implements StructureCreator {
    @Override
    public Line create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Line line = new Line(
                centerPosition,
                MathFunctions.getRelativeFromAbsolute(centerPosition, startPosition),
                MathFunctions.getRelativeFromAbsolute(centerPosition, endPosition)
        );
        line.setColor(App.getSession().getProperties().getCurrentColor());
        line.setStroke(App.getSession().getProperties().getCurrentStroke());
        return line;
    }
}
