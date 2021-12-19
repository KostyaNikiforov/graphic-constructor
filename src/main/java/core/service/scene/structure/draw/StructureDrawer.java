package core.service.scene.structure.draw;

import java.awt.Graphics2D;
import core.model.Structure;

public interface StructureDrawer {
    void draw(Structure structure, Graphics2D g);
}
