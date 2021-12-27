package core.service.scene.structure.processing;

import core.model.Structure;
import core.service.scene.structure.processing.center.update.CenterPointUpdater;
import core.service.scene.structure.processing.copy.StructureCopyist;
import core.service.scene.structure.processing.create.StructureCreator;
import core.service.scene.structure.processing.draw.RelativeStructureDrawer;
import core.service.scene.structure.processing.draw.StructureDrawer;
import core.service.scene.structure.processing.pick.StructurePicker;

public interface StructureProcessing<T extends Structure> extends
        RelativeStructureDrawer<T>,
        StructureDrawer<T>,
        StructureCreator<T>,
        StructurePicker<T>,
        CenterPointUpdater<T>,
        StructureCopyist<T> {
}
