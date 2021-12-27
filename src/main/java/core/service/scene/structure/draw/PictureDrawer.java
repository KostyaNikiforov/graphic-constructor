package core.service.scene.structure.draw;

import core.model.Picture;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;

public class PictureDrawer implements StructureDrawer, RelativeStructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Picture picture = (Picture) structure;
        drawRect(g, picture, structure.getRelativePoints().get("start"));
    }

    @Override
    public void draw(Structure structure, Graphics2D g, Point basePoint) {
        Picture picture = (Picture) structure;
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, structure.getRelativePoints().get("start"));
        drawRect(g, picture, startPoint);
    }

    private void drawRect(Graphics2D g, Picture picture, Point startPoint) {
        initGraphic(g, picture);
        g.drawImage(picture.getContent(), startPoint.x, startPoint.y,
                picture.getWidth(), picture.getHeight(), new Panel());
    }
}
