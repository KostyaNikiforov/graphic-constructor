package core.service.scene.structure.control;

import core.model.Structure;
import java.awt.Point;
import java.util.Optional;

public interface StructureSearcher {
    Optional<Structure> findStructureOnPosition(Point position);
}
