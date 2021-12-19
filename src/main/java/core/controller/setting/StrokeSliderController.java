package core.controller.setting;

import core.App;
import core.controller.SliderController;
import core.model.Structure;

public class StrokeSliderController implements SliderController {
    @Override
    public void apply(int value) {
        App.getSession().getProperties()
                .setCurrentStroke(value);
        Structure structure = App.getSession().getProperties().getChosenStructure();
        if (structure != null) {
            structure.setStroke(value);
        }
        App.getSession().getSceneControl().update();
    }
}
