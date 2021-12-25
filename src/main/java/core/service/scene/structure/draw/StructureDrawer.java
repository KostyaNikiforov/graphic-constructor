package core.service.scene.structure.draw;

import core.model.Structure;
import java.awt.Graphics2D;

public interface StructureDrawer extends AbstractDrawer {
    void draw(Structure structure, Graphics2D g);
}
