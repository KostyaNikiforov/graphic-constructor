package core.service.scene.structure.create;

import core.App;
import core.model.Picture;
import core.utils.MathFunctions;
import java.awt.Point;

public class PictureCreator implements StructureCreator {
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
}
