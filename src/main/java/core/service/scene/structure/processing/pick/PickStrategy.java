package core.service.scene.structure.processing.pick;

import core.session.enums.CreatingMode;

public interface PickStrategy {
    StructurePicker getStructurePicker(CreatingMode structureType);
}
