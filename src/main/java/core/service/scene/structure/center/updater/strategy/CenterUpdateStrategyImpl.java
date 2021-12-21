package core.service.scene.structure.center.updater.strategy;

import core.lib.Service;
import core.model.type.StructureType;
import core.service.exception.NoRealisationException;
import core.service.scene.structure.center.updater.CenterPointUpdater;
import core.service.scene.structure.center.updater.CircleCenterUpdater;
import core.service.scene.structure.center.updater.LineCenterUpdater;
import core.service.scene.structure.center.updater.RectCenterUpdater;
import java.util.HashMap;
import java.util.Map;

@Service
public class CenterUpdateStrategyImpl implements CenterUpdateStrategy {
    private final Map<StructureType, CenterPointUpdater> centerPointUpdaterMap;

    public CenterUpdateStrategyImpl() {
        centerPointUpdaterMap = new HashMap<>();
        centerPointUpdaterMap.put(StructureType.CIRCLE, new CircleCenterUpdater());
        centerPointUpdaterMap.put(StructureType.RECT, new RectCenterUpdater());
        centerPointUpdaterMap.put(StructureType.LINE, new LineCenterUpdater());
    }

    @Override
    public CenterPointUpdater getCenterPointUpdater(StructureType structureType) {
        CenterPointUpdater centerPointUpdater = centerPointUpdaterMap.get(structureType);
        if (centerPointUpdater == null) {
            throw new NoRealisationException(
                    "Cannot find CenterPointUpdater for structure type: " + structureType);
        }
        return centerPointUpdater;
    }
}
