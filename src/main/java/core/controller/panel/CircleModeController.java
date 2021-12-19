package core.controller.panel;

import core.App;
import core.controller.Controller;
import core.session.enums.CreatingMode;

public class CircleModeController implements Controller {
    @Override
    public void apply() {
        App.getSession().getProperties().setCreatingMode(CreatingMode.CIRCLE);
    }
}
