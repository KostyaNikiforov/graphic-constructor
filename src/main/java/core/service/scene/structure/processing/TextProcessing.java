package core.service.scene.structure.processing;

import core.App;
import core.lib.Service;
import core.model.Text;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

@Service
public class TextProcessing implements StructureProcessing<Text> {
    @Override
    public Text create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Text text = new Text(centerPosition, startPosition, endPosition);
        text.setColor(text.getColor());
        return text;
    }

    @Override
    public void relativeDraw(Text text, Graphics2D g, Point basePoint) {
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, text.getRelativePoints().get("start"));
        drawText(g, text, startPoint);
    }

    @Override
    public void draw(Text text, Graphics2D g) {
        drawText(g, text, text.getRelativePoints().get("start"));
    }

    private void drawText(Graphics2D g, Text text, Point startPoint) {
        initGraphic(g, text);
        g.setFont(text.getFont());
        Point endPoint = text.getRelativePoints().get("end");
        g.drawString(text.getContent(), startPoint.x,
                startPoint.y + (endPoint.y - startPoint.y));
    }
}
