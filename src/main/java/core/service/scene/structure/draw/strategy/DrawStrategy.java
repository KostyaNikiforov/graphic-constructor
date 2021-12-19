package core.service.scene.structure.draw.strategy;

import core.model.type.StructureType;
import core.service.scene.structure.draw.StructureDrawer;

public interface DrawStrategy {
    StructureDrawer getStructureDrawer(StructureType structureType);
}
