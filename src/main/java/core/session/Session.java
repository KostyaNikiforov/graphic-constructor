package core.session;

import core.App;
import core.gui.Window;
import core.gui.models.canvas.SceneCanvas;
import core.model.Scene;
import core.service.processe.strategy.ProcessesStrategy;
import core.service.scene.SceneControl;
import core.service.scene.SceneControlImpl;
import java.awt.Point;

public class Session {
    private final ProcessesStrategy processesStrategy
            = (ProcessesStrategy) App.serviceInjector.getInstance(ProcessesStrategy.class);
    private final Properties properties;
    private SceneControl sceneControl;
    private Window mainWindow;

    public Session() {
        properties = new Properties();
    }

    public void finishAllProcessesAndUpdate(Point point) {
        processesStrategy.getProcessHandler(properties.getCreatingMode())
                .finish(point);
        sceneControl.update();
    }

    public void startProcess(Point point) {
        processesStrategy.getProcessHandler(properties.getCreatingMode())
                .start(point);
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
