package core.service.scene.structure.draw;

import core.model.Rect;
import core.model.Structure;
import java.awt.Graphics2D;

public class RectDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Rect rect = (Rect) structure;
        g.drawRect(
                (int) (rect.getStartPoint().getX()),
                (int) (rect.getStartPoint().getY()),
                rect.getWidth(),
                rect.getHeight()
        );
    }
}
