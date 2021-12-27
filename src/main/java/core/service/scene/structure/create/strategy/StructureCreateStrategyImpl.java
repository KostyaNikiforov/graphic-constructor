package core.service.scene.structure.create.strategy;

import core.lib.Service;
import core.service.exception.NoRealisationException;
import core.service.scene.structure.create.CircleCreator;
import core.service.scene.structure.create.LineCreator;
import core.service.scene.structure.create.RectCreator;
import core.service.scene.structure.create.StructureCreator;
import core.service.scene.structure.create.TextCreator;
import core.session.enums.CreatingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class StructureCreateStrategyImpl implements StructureCreateStrategy {
    private final Map<CreatingMode, StructureCreator> structureCreatorMap;

    public StructureCreateStrategyImpl() {
        structureCreatorMap = new HashMap<>();
        structureCreatorMap.put(CreatingMode.CIRCLE, new CircleCreator());
        structureCreatorMap.put(CreatingMode.LINE, new LineCreator());
        structureCreatorMap.put(CreatingMode.RECT, new RectCreator());
        structureCreatorMap.put(CreatingMode.TEXT, new TextCreator());
    }

    @Override
    public StructureCreator getStructureCreator(CreatingMode creatingMode) {
        StructureCreator structureCreator = structureCreatorMap.get(creatingMode);
        if (structureCreator == null) {
            throw new NoRealisationException(
                    "Cannot find StructureCreator for creating mod: " + creatingMode);
        }
        return structureCreator;
    }
}
