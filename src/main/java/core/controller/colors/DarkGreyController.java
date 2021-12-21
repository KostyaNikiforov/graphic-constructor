package core.controller.colors;

import core.controller.Controller;
import core.lib.Injector;
import core.service.session.update.PropertiesUpdater;
import core.service.session.update.StructureUpdater;
import java.awt.Color;

public class DarkGreyController implements Controller {
    private static final Injector injector = Injector.getInstance("core.controller.colors.service");
    private final PropertiesUpdater propertiesUpdater
            = (PropertiesUpdater) injector.getInstance(PropertiesUpdater.class);
    private final StructureUpdater structureUpdater
            = (StructureUpdater) injector.getInstance(StructureUpdater.class);

    @Override
    public void apply() {
        Color color = Color.DARK_GRAY;
        propertiesUpdater.updateCurrentSessionColor(color);
        structureUpdater.updateChosenStructure(color);
    }
}
