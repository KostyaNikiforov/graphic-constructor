package core.service.scene.structure.processing.strategy;

import core.service.scene.structure.processing.center.update.CenterUpdateStrategy;
import core.service.scene.structure.processing.copy.StructureCopyStrategy;
import core.service.scene.structure.processing.create.StructureCreateStrategy;
import core.service.scene.structure.processing.draw.DrawStrategy;
import core.service.scene.structure.processing.draw.RelativeDrawStrategy;
import core.service.scene.structure.processing.pick.PickStrategy;

public interface StructureProcessingStrategy extends
        StructureCreateStrategy, DrawStrategy, RelativeDrawStrategy,
        PickStrategy, CenterUpdateStrategy, StructureCopyStrategy {
}
