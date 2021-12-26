package core.service.scene;

import static core.service.scene.structure.control.StructureChooser.structureToSettingComponents;

import core.App;
import core.model.Scene;
import core.model.Structure;
import core.service.scene.history.History;
import core.service.scene.history.HistoryImpl;
import core.service.scene.structure.StructureContainer;
import core.session.enums.CreatingMode;
import core.utils.sys.Machine;
import java.awt.Color;
import java.awt.Point;

public class SceneControlImpl implements SceneControl {
    private final Scene scene;

    public SceneControlImpl(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void undo() {
        //scene.moveToLastVersion();
        if (!scene.getStructureContainer().isEmpty()) {
            scene.getStructureContainer().getAllStructures()
                    .remove(scene.getStructureContainer().size() - 1);
        }
    }

    @Override
    public void redo() {
        //scene.moveToNextVersion();
    }

    @Override
    public void saveState() {
        scene.addNewVersion();
    }

    @Override
    public void update() {
        scene.getSceneCanvas().repaint();
        Structure chosenStructure = App.getSession().getProperties().getChosenStructure();
        if (chosenStructure != null) {
            // TODO: Update text fields on the settings left panel
        }
        App.getSession().getMainWindow()
                .getMemoryInfoContainer()
                .updateMemoryInfoText(Machine.getUsedMemory(), Machine.getTotalMemory());
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void createNewStructure(Point startPoint, Point endPoint) {
        CreatingMode creatingMode = App.getSession().getProperties().getCreatingMode();
        Color currentColor = App.getSession().getProperties().getCurrentColor();
        Structure structure = scene.getStructureCreateStrategy().getStructureCreator(creatingMode)
                .create(startPoint, endPoint);
        structure.setColor(currentColor);
        scene.getStructureContainer().add(structure);
    }
}
