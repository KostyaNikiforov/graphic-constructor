package core.service.scene.structure.control;

import java.awt.Point;
import core.model.Structure;

public interface StructureModifier {
    int VISIBILITY_RADIUS = 15;

    void modify(Structure structure, Point movedPoint);
}
