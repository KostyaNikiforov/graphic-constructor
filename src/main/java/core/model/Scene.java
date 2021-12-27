package core.model;

import core.App;
import core.gui.sections.canvas.SceneCanvas;
import core.service.scene.Drawer;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.control.StructureControl;
import core.service.scene.structure.processing.create.StructureCreateStrategy;
import core.service.scene.structure.processing.strategy.StructureProcessingStrategy;

public class Scene {
    private final StructureControl structureControl
            = (StructureControl) App.injector.getInstance(StructureControl.class);
    private final StructureCreateStrategy structureCreateStrategy
            = (StructureCreateStrategy) App.injector.getInstance(StructureProcessingStrategy.class);
    private final SceneCanvas sceneCanvas;
    private final Drawer drawer;

    public Scene(SceneCanvas sceneCanvas) {
        this.sceneCanvas = sceneCanvas;
        drawer = new Drawer(sceneCanvas, structureCreateStrategy);
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
}
