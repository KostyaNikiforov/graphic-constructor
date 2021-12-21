package core.service.scene.structure.create;

import core.App;
import core.model.Line;
import core.utils.MathFunctions;
import java.awt.Point;

public class LineCreator implements StructureCreator {
    @Override
    public Line create(Point startPosition, Point endPosition) {
        Line line = new Line(
                MathFunctions.getCenterPosition(startPosition, endPosition),
                startPosition,
                endPosition
        );
        line.setColor(App.getSession().getProperties().getCurrentColor());
        line.setStroke(App.getSession().getProperties().getCurrentStroke());
        return line;
    }
}
