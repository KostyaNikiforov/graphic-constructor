package core.service.scene.structure.create.strategy;

import core.service.scene.structure.create.StructureCreator;
import core.session.enums.CreatingMode;

public interface StructureCreateStrategy {
    StructureCreator getStructureCreator(CreatingMode creatingMode);
}
