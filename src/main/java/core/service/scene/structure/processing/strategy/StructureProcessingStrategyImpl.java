package core.service.scene.structure.processing.strategy;

import core.lib.Service;
import core.service.scene.structure.processing.CircleProcessing;
import core.service.scene.structure.processing.LayerProcessing;
import core.service.scene.structure.processing.LineProcessing;
import core.service.scene.structure.processing.PictureProcessing;
import core.service.scene.structure.processing.RectProcessing;
import core.service.scene.structure.processing.TextProcessing;
import core.service.scene.structure.processing.center.update.CenterPointUpdater;
import core.service.scene.structure.processing.copy.StructureCopyist;
import core.service.scene.structure.processing.create.StructureCreator;
import core.service.scene.structure.processing.draw.RelativeStructureDrawer;
import core.service.scene.structure.processing.draw.StructureDrawer;
import core.service.scene.structure.processing.pick.StructurePicker;
import core.session.enums.CreatingMode;
import java.util.HashMap;
import java.util.Map;

@Service
public class StructureProcessingStrategyImpl implements StructureProcessingStrategy {
    private final Map<CreatingMode, StructureCreator> structureProcessingMap;

    public StructureProcessingStrategyImpl() {
        structureProcessingMap = new HashMap<>();
        structureProcessingMap.put(CreatingMode.CIRCLE, new CircleProcessing());
        structureProcessingMap.put(CreatingMode.RECT, new RectProcessing());
        structureProcessingMap.put(CreatingMode.LINE, new LineProcessing());
        structureProcessingMap.put(CreatingMode.LAYER, new LayerProcessing());
        structureProcessingMap.put(CreatingMode.TEXT, new TextProcessing());
        structureProcessingMap.put(CreatingMode.PICTURE, new PictureProcessing());
    }

    @Override
    public StructureCreator getStructureCreator(CreatingMode creatingMode) {
        return structureProcessingMap.get(creatingMode);
    }

    @Override
    public StructureDrawer getStructureDrawer(CreatingMode creatingMode) {
        return (StructureDrawer) structureProcessingMap.get(creatingMode);
    }

    @Override
    public RelativeStructureDrawer getRelativeStructureDrawer(CreatingMode creatingMode) {
        return (RelativeStructureDrawer) structureProcessingMap.get(creatingMode);
    }

    @Override
    public StructurePicker getStructurePicker(CreatingMode creatingMode) {
        return (StructurePicker) structureProcessingMap.get(creatingMode);
    }

    @Override
    public CenterPointUpdater getCenterPointUpdater(CreatingMode creatingMode) {
        return (CenterPointUpdater) structureProcessingMap.get(creatingMode);
    }

    @Override
    public StructureCopyist getStructureCopyist(CreatingMode creatingMode) {
        return (StructureCopyist) structureProcessingMap.get(creatingMode);
    }
}
