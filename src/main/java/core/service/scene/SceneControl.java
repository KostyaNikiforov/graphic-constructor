package core.service.scene;

import core.model.Scene;
import java.awt.Point;

public interface SceneControl {
    void undo();

    void redo();

    void saveState();

    void update();

    Scene getScene();

    void createNewStructure(Point startPoint, Point endPoint);
}
