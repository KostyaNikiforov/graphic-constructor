package core.service.scene.structure.draw;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public interface RelativeStructureDrawer extends AbstractDrawer {
    void draw(Structure structure, Graphics2D g, Point basePoint);
}
