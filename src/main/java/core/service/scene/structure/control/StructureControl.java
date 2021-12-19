package core.service.scene.structure.control;

import core.model.Structure;

public interface StructureControl extends StructureSearcher, StructurePositioner {
    void remove(Structure structure);
}
