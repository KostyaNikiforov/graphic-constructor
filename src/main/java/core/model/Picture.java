package core.model;

import core.service.image.load.ImageReader;
import core.service.image.load.ImageReaderImpl;
import core.session.enums.CreatingMode;
import java.awt.Image;
import java.awt.Point;

public class Picture extends Rect {
    private final ImageReader imageReader;
    private Image content;

    {
        imageReader = new ImageReaderImpl();
    }

    public Picture(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, startPoint, endPoint);
        setCreatingMode(CreatingMode.PICTURE);
    }

    public Image getContent() {
        return content;
    }

    public void setContentFromPath(String filePath) {
        content = imageReader.read(filePath);
    }
}
