package core.controller.menu;

import core.controller.Controller;
import javax.swing.JOptionPane;

public class TestController implements Controller {
    @Override
    public void apply() {
        JOptionPane.showMessageDialog(null, "There are no tests.");
    }
}
