package core.service.scene.structure.control;

import core.model.Structure;
import java.awt.Point;

public interface StructurePositioner {
    void moveStructureTo(Structure structure, Point point);
}
