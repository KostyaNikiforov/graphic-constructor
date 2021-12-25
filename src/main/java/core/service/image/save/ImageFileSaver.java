package core.service.image.save;

import java.awt.image.RenderedImage;
import java.io.File;

public interface ImageFileSaver {
    void save(RenderedImage image, File file);
}
