package core.service.scene.structure.pick.strategy;

import core.lib.Service;
import core.model.type.StructureType;
import core.service.scene.structure.pick.CirclePicker;
import core.service.scene.structure.pick.LayerPicker;
import core.service.scene.structure.pick.LinePicker;
import core.service.scene.structure.pick.PicturePicker;
import core.service.scene.structure.pick.RectPicker;
import core.service.scene.structure.pick.StructurePicker;
import core.service.scene.structure.pick.TextPicker;
import java.util.HashMap;
import java.util.Map;

@Service
public class PickStrategyImpl implements PickStrategy {
    private final Map<StructureType, StructurePicker> pickerMap;

    public PickStrategyImpl() {
        pickerMap = new HashMap<>();
        pickerMap.put(StructureType.LINE, new LinePicker());
        pickerMap.put(StructureType.RECT, new RectPicker());
        pickerMap.put(StructureType.CIRCLE, new CirclePicker());
        pickerMap.put(StructureType.LAYER, new LayerPicker());
        pickerMap.put(StructureType.PICTURE, new PicturePicker());
        pickerMap.put(StructureType.TEXT, new TextPicker());
    }

    @Override
    public StructurePicker getStructurePicker(StructureType structureType) {
        return pickerMap.get(structureType);
    }
}
