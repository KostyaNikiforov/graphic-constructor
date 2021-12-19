package core.controller.menu;

import core.App;
import core.controller.Controller;

public class TimeController implements Controller {
    @Override
    public void apply() {
        if (App.getSession().getProperties().isAutoUpdate()) {
            App.getSession().getProperties().setAutoUpdate(false);
        } else {
            App.getSession().getProperties().setAutoUpdate(true);
        }
        System.out.println(App.getSession().getProperties().isAutoUpdate());
    }
}
