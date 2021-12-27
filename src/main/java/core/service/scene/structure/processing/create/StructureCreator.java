package core.service.scene.structure.processing.create;

import core.model.Structure;
import java.awt.Point;

public interface StructureCreator<T extends Structure> {
    T create(Point startPosition, Point endPosition);
}
