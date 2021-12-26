package core.model;

import core.gui.models.canvas.SceneCanvas;
import core.lib.Injector;
import core.service.scene.Drawer;
import core.service.scene.history.History;
import core.service.scene.history.HistoryImpl;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.control.StructureControl;
import core.service.scene.structure.create.strategy.StructureCreateStrategy;
import core.service.scene.structure.create.strategy.StructureCreateStrategyImpl;

public class Scene {
    private static final Injector injector = Injector.getInstance("core.service.scene.structure");
    private final StructureControl structureControl
            = (StructureControl) injector.getInstance(StructureControl.class);
    private final History<StructureContainer> history;
    private final StructureCreateStrategy structureCreateStrategy;
    private final SceneCanvas sceneCanvas;
    private final Drawer drawer;
    private final Layer layer;

    public Scene(SceneCanvas sceneCanvas) {
        this.sceneCanvas = sceneCanvas;
        structureCreateStrategy = new StructureCreateStrategyImpl();
        drawer
                = new Drawer(sceneCanvas, structureCreateStrategy);
        layer = new Layer(0, 0, 700, 500); // DEFAULT VALUES
        history = new HistoryImpl();
    }

    public StructureControl getStructureControl() {
        return structureControl;
    }

    public SceneCanvas getSceneCanvas() {
        return sceneCanvas;
    }

    public StructureCreateStrategy getStructureCreateStrategy() {
        return structureCreateStrategy;
    }

    public Drawer getDrawer() {
        return drawer;
    }

    public StructureContainer getStructureContainer() {
        return structureControl.getStructureContainer();
    }

    public Layer getLayer() {
        return layer;
    }

    public void moveToLastVersion() {
        StructureContainer last = history.last();
        structureControl.updateContainer(last);
    }

    public void moveToNextVersion() {
        StructureContainer next = history.next();
        structureControl.updateContainer(next);
    }

    public void addNewVersion() {
        history.add(getStructureContainer());
    }
}
