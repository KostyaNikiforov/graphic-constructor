package core.service.scene.structure.draw.strategy;

import java.util.HashMap;
import java.util.Map;
import core.lib.Service;
import core.model.types.StructureType;
import core.service.scene.structure.draw.CircleDrawer;
import core.service.scene.structure.draw.LineDrawer;
import core.service.scene.structure.draw.RectDrawer;
import core.service.scene.structure.draw.StructureDrawer;

@Service
public class DrawStrategyImpl implements DrawStrategy {
    private final Map<StructureType, StructureDrawer> drawerMap;

    public DrawStrategyImpl() {
        drawerMap = new HashMap<>();
        drawerMap.put(StructureType.CIRCLE, new CircleDrawer());
        drawerMap.put(StructureType.RECT, new RectDrawer());
        drawerMap.put(StructureType.LINE, new LineDrawer());
    }

    @Override
    public StructureDrawer getStructureDrawer(StructureType structureType) {
        return drawerMap.get(structureType);
    }
}
