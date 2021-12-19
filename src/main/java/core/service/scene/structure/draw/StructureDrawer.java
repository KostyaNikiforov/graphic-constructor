package core.service.scene.structure.draw;

import core.model.Structure;
import java.awt.Graphics2D;

public interface StructureDrawer {
    void draw(Structure structure, Graphics2D g);
}
