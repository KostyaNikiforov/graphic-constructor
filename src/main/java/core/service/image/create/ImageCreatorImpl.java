package core.service.image.create;

import core.App;
import core.lib.Service;
import core.model.Structure;
import core.service.image.create.file.FileChooser;
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
    private FileChooser fileChooser
            = (FileChooser) App.serviceInjector.getInstance(FileChooser.class);
    private ImageFileSaver imageFileSaver;

    {
        imageFileSaver = new PngImageFileSaver();
    }

    @Override
    public void create(Point startPoint, Point endPoint, String filePath) {
        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        StructureContainer structureContainer = App.getSession().getSceneControl()
                .getScene().getStructureContainer();
        drawStructuresOnImage(structureContainer.getAllStructures(), graphics, startPoint);
        filePath = fileChooser.openChooseWindow();
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
