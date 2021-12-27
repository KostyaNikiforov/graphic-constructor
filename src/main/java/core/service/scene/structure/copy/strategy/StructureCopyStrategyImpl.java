package core.service.scene.structure.copy.strategy;

import core.lib.Service;
import core.model.type.StructureType;
import core.service.exception.NoRealisationException;
import core.service.scene.structure.copy.CircleCopyist;
import core.service.scene.structure.copy.LineCopyist;
import core.service.scene.structure.copy.RectCopyist;
import core.service.scene.structure.copy.StructureCopyist;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

@Service
public class StructureCopyStrategyImpl implements StructureCopyStrategy {
    private final Map<StructureType, StructureCopyist> structureCopyistMap;

    public StructureCopyStrategyImpl() {
        structureCopyistMap = new HashMap<>();
        structureCopyistMap.put(StructureType.RECT, new RectCopyist());
        structureCopyistMap.put(StructureType.LINE, new LineCopyist());
        structureCopyistMap.put(StructureType.CIRCLE, new CircleCopyist());
    }

    @Override
    public StructureCopyist getStructureCopyist(StructureType structureType) {
        StructureCopyist structureCopyist = structureCopyistMap.get(structureType);
        if (structureCopyist == null) {
            JOptionPane.showMessageDialog(null, "You can't copy this element.");
            throw new NoRealisationException("Cannot find StructureCopyist for: " + structureType);
        }
        return structureCopyist;
    }
}
