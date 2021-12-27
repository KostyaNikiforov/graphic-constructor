package core.service.scene.structure.create;

import core.App;
import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;

public class RectCreator implements StructureCreator {
    @Override
    public Structure create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Rect rect = new Rect(
                centerPosition,
                startPosition,
                endPosition
        );
        rect.setColor(App.getSession().getProperties().getCurrentColor());
        rect.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return rect;
    }
}
