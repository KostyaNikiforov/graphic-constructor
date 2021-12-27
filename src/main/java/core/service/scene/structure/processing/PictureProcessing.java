package core.service.scene.structure.processing;

import core.App;
import core.lib.Service;
import core.model.Picture;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;

@Service
public class PictureProcessing implements StructureProcessing<Picture> {
    @Override
    public Picture create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Picture picture = new Picture(
                centerPosition,
                startPosition,
                endPosition
        );
        picture.setColor(App.getSession().getProperties().getCurrentColor());
        picture.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return picture;
    }

    @Override
    public void relativeDraw(Picture picture, Graphics2D g, Point basePoint) {
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, picture.getRelativePoints().get("start"));
        drawPicture(g, picture, startPoint);
    }

    @Override
    public void draw(Picture picture, Graphics2D g) {
        drawPicture(g, picture, picture.getRelativePoints().get("start"));
    }

    private void drawPicture(Graphics2D g, Picture picture, Point startPoint) {
        initGraphic(g, picture);
        g.drawImage(picture.getContent(), startPoint.x, startPoint.y,
                picture.getWidth(), picture.getHeight(), new Panel());
    }
}
