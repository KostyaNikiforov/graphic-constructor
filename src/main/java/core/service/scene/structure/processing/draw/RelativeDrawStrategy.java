package core.service.scene.structure.processing.draw;

import core.session.enums.CreatingMode;

public interface RelativeDrawStrategy {
    RelativeStructureDrawer getRelativeStructureDrawer(CreatingMode structureType);
}
