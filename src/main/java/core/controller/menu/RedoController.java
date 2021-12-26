package core.controller.menu;

import core.App;
import core.controller.Controller;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedoController implements Controller {
    private static final Logger logger = LogManager.getLogger(RedoController.class);

    @Override
    public void apply() {
        logger.info("Redo function is used.");
        App.getSession().getSceneControl().redo();
        App.getSession().getSceneControl().update();
        //JOptionPane.showMessageDialog(null, "Doesn't work yet.");
    }
}
