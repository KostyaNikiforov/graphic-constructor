package core.controller.colors;

import core.App;
import core.controller.Controller;
import core.service.session.update.PropertiesUpdater;
import core.service.session.update.StructureUpdater;
import java.awt.Color;

public class BlackController implements Controller {
    private final PropertiesUpdater propertiesUpdater
            = (PropertiesUpdater) App.serviceInjector.getInstance(PropertiesUpdater.class);
    private final StructureUpdater structureUpdater
            = (StructureUpdater) App.serviceInjector.getInstance(StructureUpdater.class);

    @Override
    public void apply() {
        Color color = Color.BLACK;
        propertiesUpdater.updateCurrentSessionColor(color);
        structureUpdater.updateChosenStructure(color);
    }
}
