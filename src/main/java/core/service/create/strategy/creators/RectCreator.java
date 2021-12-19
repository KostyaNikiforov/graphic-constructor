package core.service.create.strategy.creators;

import core.App;
import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;

public class RectCreator implements StructureCreator {
    @Override
    public Structure create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Rect rect = new Rect(centerPosition, startPosition, endPosition);
        rect.setColor(App.getSession().getProperties().getCurrentColor());
        rect.setStroke(App.getSession().getProperties().getCurrentStroke());
        return rect;
    }
}
