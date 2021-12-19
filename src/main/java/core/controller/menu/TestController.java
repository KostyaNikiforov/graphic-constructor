package core.controller.menu;

import javax.swing.JOptionPane;
import core.controller.Controller;

public class TestController implements Controller {
    @Override
    public void apply() {
        JOptionPane.showMessageDialog(null, "There are no tests.");
    }
}
