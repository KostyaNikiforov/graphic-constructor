package core.service.scene.structure.draw;

import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

public class LayerDrawer implements StructureDrawer, RelativeStructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Rect rect = (Rect) structure;
        drawRect(g, rect, structure.getRelativePoints().get("start"));
    }

    @Override
    public void draw(Structure structure, Graphics2D g, Point basePoint) {
        Rect rect = (Rect) structure;
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, structure.getRelativePoints().get("start"));
        drawRect(g, rect, startPoint);
    }

    private void drawRect(Graphics2D g, Rect rect, Point startPoint) {
        initGraphic(g, rect);
        g.fillRect(
                startPoint.x,
                startPoint.y,
                rect.getWidth(),
                rect.getHeight()
        );
    }
}
