package core.session;

import java.awt.Point;
import core.gui.Window;
import core.gui.models.canvas.SceneCanvas;
import core.model.Scene;
import core.service.scene.SceneControl;
import core.service.scene.SceneControlImpl;
import core.session.enums.CreatingMode;
import core.utils.sys.Machine;

public class Session {
    private final Properties properties;
    private SceneControl sceneControl;
    private Window mainWindow;

    public Session() {
        properties = new Properties();
    }

    public void finishAllProcessesAndUpdate(Point point) {
        if (properties.getCreatingMode() != CreatingMode.MOVING
                && properties.getCreatingMode() != CreatingMode.HIGHLIGHTING) {
            sceneControl.createNewStructure(properties.getStartPoint(), point);
        }
        sceneControl.update();
        mainWindow.getMemoryInfoContainer()
                .updateMemoryInfoText(Machine.getUsedMemory(), Machine.getTotalMemory());
    }

    public void run() {
        SceneCanvas sceneCanvas = new SceneCanvas();
        Scene scene = new Scene(sceneCanvas);
        mainWindow = new Window(sceneCanvas);
        sceneControl = new SceneControlImpl(scene);
        mainWindow.create();
    }

    public SceneControl getSceneControl() {
        return sceneControl;
    }

    public Properties getProperties() {
        return properties;
    }

    public Window getMainWindow() {
        return mainWindow;
    }
}
