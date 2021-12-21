package core.service.scene.structure.copy.strategy;

import core.lib.Service;
import core.model.type.StructureType;
import core.service.exception.NoRealisationException;
import core.service.scene.structure.copy.CircleCopyist;
import core.service.scene.structure.copy.LineRectCopyist;
import core.service.scene.structure.copy.StructureCopyist;
import java.util.HashMap;
import java.util.Map;

@Service
public class StructureCopyStrategyImpl implements StructureCopyStrategy {
    private final Map<StructureType, StructureCopyist> structureCopyistMap;

    public StructureCopyStrategyImpl() {
        structureCopyistMap = new HashMap<>();
        LineRectCopyist lineRectCopyist = new LineRectCopyist();
        structureCopyistMap.put(StructureType.RECT, lineRectCopyist);
        structureCopyistMap.put(StructureType.LINE, lineRectCopyist);
        structureCopyistMap.put(StructureType.CIRCLE, new CircleCopyist());
    }

    @Override
    public StructureCopyist getStructureCopyist(StructureType structureType) {
        StructureCopyist structureCopyist = structureCopyistMap.get(structureType);
        if (structureCopyist == null) {
            throw new NoRealisationException("Cannot find StructureCopyist for: " + structureType);
        }
        return structureCopyist;
    }
}
