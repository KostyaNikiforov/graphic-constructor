package core.service.image.load;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageReaderImpl implements ImageReader {
    @Override
    public Image read(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read image from path: " + filePath, e);
        }
    }
}
