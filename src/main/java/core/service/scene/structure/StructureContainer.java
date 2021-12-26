package core.service.scene.structure;

import core.model.Structure;
import java.util.List;

public interface StructureContainer extends Cloneable {
    List<Structure> getAllStructures();

    void add(Structure structure);

    void clear();

    boolean isEmpty();

    int size();

    StructureContainer clone();
}
