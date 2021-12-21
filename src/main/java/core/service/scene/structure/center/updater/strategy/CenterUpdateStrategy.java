package core.service.scene.structure.center.updater.strategy;

import core.model.type.StructureType;
import core.service.scene.structure.center.updater.CenterPointUpdater;

public interface CenterUpdateStrategy {
    CenterPointUpdater getCenterPointUpdater(StructureType structureType);
}
