package core.service.scene;

import java.awt.Point;
import core.model.Scene;

public interface SceneControl {
    void undo();

    void redo();

    void saveState();

    void update();

    Scene getScene();

    void createNewStructure(Point startPoint, Point endPoint);
}
