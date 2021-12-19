package core.controller.menu;

import core.App;
import core.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UndoController implements Controller {
    private static final Logger logger = LogManager.getLogger(UndoController.class);

    @Override
    public void apply() {
        logger.info("Got last version of document.");
        App.getSession().getSceneControl().undo();
        App.getSession().getSceneControl().update();
    }
}
