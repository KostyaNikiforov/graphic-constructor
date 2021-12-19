package core.service.scene.structure.control;

import core.model.Structure;
import core.service.scene.structure.StructureContainer;

public interface StructureControl extends StructureSearcher, StructurePositioner {
    void remove(Structure structure);

    StructureContainer getStructureContainer();
}
