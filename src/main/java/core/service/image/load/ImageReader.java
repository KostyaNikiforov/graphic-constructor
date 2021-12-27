package core.service.image.load;

import java.awt.Image;

public interface ImageReader {
    Image read(String filePath);
}
