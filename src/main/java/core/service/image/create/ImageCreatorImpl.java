package core.service.image.create;

import core.App;
import core.lib.Service;
import core.model.Structure;
import core.service.image.save.ImageFileSaver;
import core.service.image.save.PngImageFileSaver;
import core.service.scene.structure.StructureContainer;
import core.service.scene.structure.draw.strategy.DrawStrategy;
import core.service.scene.structure.draw.strategy.RelativeDrawStrategy;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

@Service
public class ImageCreatorImpl implements ImageCreator {
    private RelativeDrawStrategy relativeDrawStrategy
            = (RelativeDrawStrategy) App.serviceInjector.getInstance(DrawStrategy.class);
    private ImageFileSaver imageFileSaver;

    {
        imageFileSaver = new PngImageFileSaver();
    }

    @Override
    public void create(Point startPoint, Point endPoint, String filePath) {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        StructureContainer structureContainer = App.getSession().getSceneControl()
                .getScene().getStructureContainer();
        drawStructuresOnImage(structureContainer.getAllStructures(), graphics, startPoint);
        imageFileSaver.save(bufferedImage, new File(filePath));
    }

    private void drawStructuresOnImage(List<Structure> structures,
                                       Graphics2D graphics, Point basePoint) {
        for (Structure structure : structures) {
            relativeDrawStrategy.getRelativeStructureDrawer(structure.getType())
                    .draw(structure, graphics, basePoint);
        }
    }
}
