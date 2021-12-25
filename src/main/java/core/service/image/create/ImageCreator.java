package core.service.image.create;

import java.awt.Point;

public interface ImageCreator {
    void create(Point startPoint, Point endPoint, String filePath);
}
