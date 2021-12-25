package core.session.event;

import core.controller.SliderController;
import core.controller.setting.StrokeSliderController;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeListener implements ChangeListener {
    private final SliderController sliderController = new StrokeSliderController();

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        sliderController.apply(((JSlider) changeEvent.getSource()).getValue());
    }
}
