package core.service.scene.structure.draw.strategy;

import core.model.types.StructureType;
import core.service.scene.structure.draw.StructureDrawer;

public interface DrawStrategy {
    StructureDrawer getStructureDrawer(StructureType structureType);
}
