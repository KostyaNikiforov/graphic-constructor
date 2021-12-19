package core.service.scene.structure;

import java.util.List;
import core.model.Structure;

public interface StructureContainer {
    List<Structure> getAllStructures();

    void add(Structure structure);

    void clear();

    boolean isEmpty();

    int size();
}
