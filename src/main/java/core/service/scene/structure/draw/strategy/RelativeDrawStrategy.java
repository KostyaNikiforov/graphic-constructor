package core.service.scene.structure.draw.strategy;

import core.model.type.StructureType;
import core.service.scene.structure.draw.RelativeStructureDrawer;

public interface RelativeDrawStrategy {
    RelativeStructureDrawer getRelativeStructureDrawer(StructureType structureType);
}
