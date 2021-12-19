package core.service.create.strategy;

import core.service.create.strategy.creators.StructureCreator;
import core.session.enums.CreatingMode;

public interface StructureCreateStrategy {
    StructureCreator getStructureCreator(CreatingMode creatingMode);
}
