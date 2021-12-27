package core.service.scene.structure.create;

import core.App;
import core.model.Text;
import core.utils.MathFunctions;
import java.awt.Point;

public class TextCreator implements StructureCreator {
    @Override
    public Text create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Text text = new Text(centerPosition, startPosition, endPosition);
        text.setColor(App.getSession().getProperties().getCurrentColor());
        return text;
    }
}
