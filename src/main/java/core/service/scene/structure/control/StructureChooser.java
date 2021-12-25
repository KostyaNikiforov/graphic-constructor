package core.service.scene.structure.control;

import core.model.Structure;
import core.service.convetror.StructureToSettingComponents;
import core.service.convetror.StructureToSettingComponentsImpl;

public interface StructureChooser {
    StructureToSettingComponents structureToSettingComponents
            = new StructureToSettingComponentsImpl();

    void chooseStructure(Structure structure);
}
