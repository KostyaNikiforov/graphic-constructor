package core.service.scene.structure.control;

import core.Config;
import core.model.Structure;
import java.awt.Point;

public interface StructureModifier {
    int VISIBILITY_RADIUS = Config.MODIFY_POINTS_VISIBILITY_RADIUS;

    void modify(Structure structure, Point movedPoint);
}
