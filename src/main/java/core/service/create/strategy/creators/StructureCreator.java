package core.service.create.strategy.creators;

import java.awt.Point;
import core.model.Structure;

public interface StructureCreator {
    Structure create(Point startPosition, Point endPosition);
}
