package core.model;

import java.awt.Point;
import core.Config;
import core.gui.models.canvas.SceneCanvas;
import core.service.create.strategy.StructureCreateStrategy;
import core.service.create.strategy.StructureCreateStrategyImpl;
import core.service.scene.Drawer;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.StructureContainerImpl;
import core.service.scene.structure.control.StructureControl;
import core.service.scene.structure.control.StructureControlImpl;

public class Scene {
    private final StructureCreateStrategy structureCreateStrategy;
    private final StructureControl structureControl;
    private final SceneCanvas sceneCanvas;
    private final Drawer drawer;
    private final StructureContainer structureContainer;
    private final Layer layer;

    public Scene(SceneCanvas sceneCanvas) {
        this.sceneCanvas = sceneCanvas;
        structureContainer
                = new StructureContainerImpl();
        structureCreateStrategy
                = new StructureCreateStrategyImpl(Config.STRUCTURE_CREATOR_MAP);
        structureControl
                = new StructureControlImpl(structureContainer);
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
        return structureContainer;
    }

    public Layer getLayer() {
        return layer;
    }
}
