package core.service.scene.structure.processing.draw;

import core.session.enums.CreatingMode;

public interface DrawStrategy {
    StructureDrawer getStructureDrawer(CreatingMode structureType);
}
