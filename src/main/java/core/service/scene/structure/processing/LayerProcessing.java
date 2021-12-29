package core.service.scene.structure.processing;

import core.App;
import core.lib.Service;
import core.model.Layer;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

@Service
public class LayerProcessing implements StructureProcessing<Layer> {
    @Override
    public Layer create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Layer layer = new Layer(
                centerPosition,
                startPosition,
                endPosition
        );
        layer.setColor(layer.getColor());
        layer.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return layer;
    }

    @Override
    public void relativeDraw(Layer layer, Graphics2D g, Point basePoint) {
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, layer.getRelativePoints().get("start"));
        drawRect(g, layer, startPoint);
    }

    @Override
    public void draw(Layer layer, Graphics2D g) {
        drawRect(g, layer, layer.getRelativePoints().get("start"));
    }

    private void drawRect(Graphics2D g, Layer layer, Point startPoint) {
        initGraphic(g, layer);
        g.fillRect(
                startPoint.x,
                startPoint.y,
                layer.getWidth(),
                layer.getHeight()
        );
    }
}
