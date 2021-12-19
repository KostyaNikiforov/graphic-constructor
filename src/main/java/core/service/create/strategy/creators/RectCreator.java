package core.service.create.strategy.creators;

import java.awt.Point;
import core.App;
import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;

public class RectCreator implements StructureCreator {
    @Override
    public Structure create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        int width = (int) Math.abs(endPosition.getX() - startPosition.getX());
        int height = (int) Math.abs(endPosition.getY() - startPosition.getY());
        Rect rect = new Rect(centerPosition, width, height);
        rect.setColor(App.getSession().getProperties().getCurrentColor());
        rect.setStroke(App.getSession().getProperties().getCurrentStroke());
        return rect;
    }
}
