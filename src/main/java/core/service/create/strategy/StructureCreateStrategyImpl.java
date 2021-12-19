package core.service.create.strategy;

import java.util.Map;
import core.service.create.strategy.creators.StructureCreator;
import core.session.enums.CreatingMode;

public class StructureCreateStrategyImpl implements StructureCreateStrategy {
    private final Map<CreatingMode, StructureCreator> creatorsMap;

    public StructureCreateStrategyImpl(Map<CreatingMode, StructureCreator> creatorsMap) {
        this.creatorsMap = creatorsMap;
    }

    @Override
    public StructureCreator getStructureCreator(CreatingMode creatingMode) {
        return creatorsMap.get(creatingMode);
    }
}
