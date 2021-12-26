package core.controller.menu;

import core.App;
import core.controller.Controller;
import core.model.Rect;
import core.model.Structure;
import javax.swing.JOptionPane;

public class TestController implements Controller {
    @Override
    public void apply() {
        Structure chosenStructure = App.getSession().getProperties().getChosenStructure();
        Rect rect = (Rect) chosenStructure;
        rect.setHeight(100);
        rect.setWidth(100);
        App.getSession().getSceneControl().update();
        //JOptionPane.showMessageDialog(null, "There are no tests.");
    }
}
