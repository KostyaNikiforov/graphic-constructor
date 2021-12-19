package core.model;

import core.Config;
import core.gui.models.canvas.SceneCanvas;
import core.lib.Injector;
import core.service.create.strategy.StructureCreateStrategy;
import core.service.create.strategy.StructureCreateStrategyImpl;
import core.service.scene.Drawer;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.control.StructureControl;

public class Scene {
    private static final Injector injector = Injector.getInstance("core.service.scene.structure");
    private final StructureControl structureControl
            = (StructureControl) injector.getInstance(StructureControl.class);
    private final StructureCreateStrategy structureCreateStrategy;
    private final SceneCanvas sceneCanvas;
    private final Drawer drawer;
    private final Layer layer;

    public Scene(SceneCanvas sceneCanvas) {
        this.sceneCanvas = sceneCanvas;
        structureCreateStrategy
                = new StructureCreateStrategyImpl(Config.STRUCTURE_CREATOR_MAP);
        drawer
                = new Drawer(sceneCanvas, structureCreateStrategy);
        layer = new Layer(0, 0, 700, 500); // DEFAULT VALUES
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
}
