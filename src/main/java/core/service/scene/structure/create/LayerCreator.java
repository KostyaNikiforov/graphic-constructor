package core.service.scene.structure.create;

import core.App;
import core.model.Layer;
import core.utils.MathFunctions;
import java.awt.Point;

public class LayerCreator implements StructureCreator {
    @Override
    public Layer create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Layer layer = new Layer(
                centerPosition,
                startPosition,
                endPosition
        );
        layer.setColor(App.getSession().getProperties().getCurrentColor());
        layer.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return layer;
    }
}
