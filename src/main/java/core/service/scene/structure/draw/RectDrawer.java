package core.service.scene.structure.draw;

import java.awt.Graphics2D;
import core.model.Rect;
import core.model.Structure;

public class RectDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Rect rect = (Rect) structure;
        g.drawRect(
                (int) (rect.getCenterPosition().getX() - rect.getWidth() / 2),
                (int) (rect.getCenterPosition().getY() - rect.getHeight() / 2),
                rect.getWidth(),
                rect.getHeight()
        );
    }
}
