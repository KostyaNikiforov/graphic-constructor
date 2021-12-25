package core.service.processe;

import core.App;
import core.Config;
import core.service.image.create.ImageCreator;
import java.awt.Point;

public class ImageExtracting implements ProcessHandler {
    private ImageCreator imageCreator
            = (ImageCreator) App.serviceInjector.getInstance(ImageCreator.class);

    @Override
    public void finish(Point point) {
        imageCreator.create(App.getSession().getProperties()
                .getStartPoint(), point, Config.DEFAULT_IMAGE_FILE_PATH);
    }
}
