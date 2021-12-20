package core.service.scene.structure.draw;

import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

public class RectDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Rect rect = (Rect) structure;
        Point absoluteStart = MathFunctions
                .getAbsolutFromRelative(rect.getCenterPosition(), rect.getStartPoint());
        g.drawRect(
                (int) (absoluteStart.getX()),
                (int) (absoluteStart.getY()),
                rect.getWidth(),
                rect.getHeight()
        );
    }
}
