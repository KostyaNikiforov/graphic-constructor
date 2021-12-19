package core.controller.colors;

import core.controller.Controller;
import core.controller.colors.service.PropertiesUpdater;
import core.controller.colors.service.StructureUpdater;
import core.lib.Injector;
import java.awt.Color;

public class BlueController implements Controller {
    private static final Injector injector = Injector.getInstance("core.controller.colors.service");
    private final PropertiesUpdater propertiesUpdater
            = (PropertiesUpdater) injector.getInstance(PropertiesUpdater.class);
    private final StructureUpdater structureUpdater
            = (StructureUpdater) injector.getInstance(StructureUpdater.class);

    @Override
    public void apply() {
        Color color = Color.BLUE;
        propertiesUpdater.updateCurrentSessionColor(color);
        structureUpdater.updateChosenStructure(color);
    }
}
