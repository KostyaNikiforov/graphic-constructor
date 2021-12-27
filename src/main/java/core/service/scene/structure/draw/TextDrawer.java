package core.service.scene.structure.draw;

import core.model.Structure;
import core.model.Text;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;

public class TextDrawer implements StructureDrawer, RelativeStructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Text text = (Text) structure;
        drawText(g, text, structure.getRelativePoints().get("start"));
    }

    @Override
    public void draw(Structure structure, Graphics2D g, Point basePoint) {
        Text text = (Text) structure;
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, structure.getRelativePoints().get("start"));
        drawText(g, text, startPoint);
    }

    private void drawText(Graphics2D g, Text text, Point startPoint) {
        initGraphic(g, text);
        g.setFont(text.getFont());
        Point endPoint = text.getRelativePoints().get("end");
        if (startPoint.y >= endPoint.y) {
            g.drawString(text.getContent(), startPoint.x, startPoint.y);
        } else {
            g.drawString(text.getContent(), startPoint.x,
                    startPoint.y + (endPoint.y - startPoint.y));
        }
    }
}
