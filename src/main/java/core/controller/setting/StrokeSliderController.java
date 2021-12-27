package core.controller.setting;

import core.App;
import core.controller.SliderController;
import core.service.session.update.StructureUpdater;

public class StrokeSliderController implements SliderController {
    private final StructureUpdater structureUpdater
            = (StructureUpdater) App.injector.getInstance(StructureUpdater.class);

    @Override
    public void apply(int value) {
        App.getSession().getProperties().setCurrentStroke(value);
        structureUpdater.updateChosenStructureStrokeWidth(value);
    }
}
