package core.service.scene.structure.processing.draw;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public interface RelativeStructureDrawer<T extends Structure> extends AbstractDrawer<T> {
    void relativeDraw(T t, Graphics2D g, Point basePoint);
}
