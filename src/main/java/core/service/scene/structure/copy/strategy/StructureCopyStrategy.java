package core.service.scene.structure.copy.strategy;

import core.model.type.StructureType;
import core.service.scene.structure.copy.StructureCopyist;

public interface StructureCopyStrategy {
    StructureCopyist getStructureCopyist(StructureType structureType);
}
