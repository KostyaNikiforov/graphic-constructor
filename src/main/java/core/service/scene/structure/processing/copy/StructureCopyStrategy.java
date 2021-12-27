package core.service.scene.structure.processing.copy;

import core.session.enums.CreatingMode;

public interface StructureCopyStrategy {
    StructureCopyist getStructureCopyist(CreatingMode creatingMode);
}
