package core.model;

import core.model.type.StructureType;
import core.service.image.load.ImageReader;
import core.service.image.load.ImageReaderImpl;
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
        setType(StructureType.PICTURE);
    }

    public Image getContent() {
        return content;
    }

    public void setContentFromPath(String filePath) {
        content = imageReader.read(filePath);
    }
}
