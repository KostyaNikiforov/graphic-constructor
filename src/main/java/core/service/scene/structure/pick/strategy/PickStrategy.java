package core.service.scene.structure.pick.strategy;

import core.model.type.StructureType;
import core.service.scene.structure.pick.StructurePicker;

public interface PickStrategy {
    StructurePicker getStructurePicker(StructureType structureType);
}
