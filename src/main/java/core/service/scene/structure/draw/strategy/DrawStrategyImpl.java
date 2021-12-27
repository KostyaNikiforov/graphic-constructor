package core.service.scene.structure.draw.strategy;

import core.lib.Service;
import core.model.type.StructureType;
import core.service.scene.structure.draw.AbstractDrawer;
import core.service.scene.structure.draw.CircleDrawer;
import core.service.scene.structure.draw.LineDrawer;
import core.service.scene.structure.draw.RectDrawer;
import core.service.scene.structure.draw.RelativeStructureDrawer;
import core.service.scene.structure.draw.StructureDrawer;
import core.service.scene.structure.draw.TextDrawer;
import java.util.HashMap;
import java.util.Map;

@Service
public class DrawStrategyImpl implements DrawStrategy, RelativeDrawStrategy {
    private final Map<StructureType, AbstractDrawer> drawerMap;

    public DrawStrategyImpl() {
        drawerMap = new HashMap<>();
        drawerMap.put(StructureType.CIRCLE, new CircleDrawer());
        drawerMap.put(StructureType.RECT, new RectDrawer());
        drawerMap.put(StructureType.LINE, new LineDrawer());
        drawerMap.put(StructureType.TEXT, new TextDrawer());
    }

    @Override
    public StructureDrawer getStructureDrawer(StructureType structureType) {
        return (StructureDrawer) drawerMap.get(structureType);
    }

    @Override
    public RelativeStructureDrawer getRelativeStructureDrawer(StructureType structureType) {
        return (RelativeStructureDrawer) drawerMap.get(structureType);
    }
}
