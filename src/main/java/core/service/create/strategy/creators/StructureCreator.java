package core.service.create.strategy.creators;

import core.model.Structure;
import java.awt.Point;

public interface StructureCreator {
    Structure create(Point startPosition, Point endPosition);
}
