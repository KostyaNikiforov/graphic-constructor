package core.service.scene.structure.create;

import core.model.Structure;
import java.awt.Point;

public interface StructureCreator {
    Structure create(Point startPosition, Point endPosition);
}
