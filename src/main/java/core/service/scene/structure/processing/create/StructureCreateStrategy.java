package core.service.scene.structure.processing.create;

import core.session.enums.CreatingMode;

public interface StructureCreateStrategy {
    StructureCreator getStructureCreator(CreatingMode creatingMode);
}
