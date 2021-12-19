package core.controller.menu;

import core.App;
import core.controller.Controller;

public class ClearController implements Controller {
    @Override
    public void apply() {
        App.getSession().getSceneControl().getScene().getStructureContainer().clear();
        App.getSession().getProperties().setChosenStructure(null);
        App.getSession().getSceneControl().update();
    }
}
