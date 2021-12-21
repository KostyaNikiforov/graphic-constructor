package core.service.scene.structure.draw;

import core.model.Rect;
import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public class RectDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Rect rect = (Rect) structure;
        Point startPoint = structure.getRelativePoints().get("start");
        g.drawRect(
                startPoint.x,
                startPoint.y,
                rect.getWidth(),
                rect.getHeight()
        );
    }
}
