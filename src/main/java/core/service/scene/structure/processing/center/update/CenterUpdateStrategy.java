package core.service.scene.structure.processing.center.update;

import core.session.enums.CreatingMode;

public interface CenterUpdateStrategy {
    CenterPointUpdater getCenterPointUpdater(CreatingMode creatingMode);
}
