package core.service.scene.structure.control;

import java.awt.Point;
import java.util.Optional;
import core.model.Structure;

public interface StructureSearcher {
    Optional<Structure> findStructureOnPosition(Point position);
}
