package core.service.image.save;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PngImageFileSaver implements ImageFileSaver {
    private static final Logger logger = LogManager.getLogger(PngImageFileSaver.class);

    @Override
    public void save(RenderedImage image, File file) {
        try {
            if (ImageIO.write(image, "PNG", file)) {
                logger.info(String.format("Image %s was saved.", file.getPath()));
            } else {
                throw new RuntimeException("Image wasn't saved.");
            }
        } catch (IOException | RuntimeException e) {
            String errorMsg = String.format("Can't save image. Path: %s", file.getPath());
            logger.info(errorMsg);
            throw new RuntimeException(errorMsg);
        }
    }
}
