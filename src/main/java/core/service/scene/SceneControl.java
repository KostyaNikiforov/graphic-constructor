package core.service.scene;

import core.model.Scene;
import core.model.Structure;
import java.awt.Point;

public interface SceneControl {
    void undo();

    void redo();

    void saveState();

    void update();

    Scene getScene();

    Structure createNewStructure(Point startPoint, Point endPoint);
}
