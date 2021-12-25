package core.service.scene.structure.draw;

import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public class LineDrawer implements StructureDrawer, RelativeStructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        drawLine(
                g,
                structure,
                relativePoints.get("start"),
                relativePoints.get("end")
        );
    }

    @Override
    public void draw(Structure structure, Graphics2D g, Point basePoint) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        drawLine(
                g,
                structure,
                MathFunctions.getRelativeFromAbsolute(basePoint, relativePoints.get("start")),
                MathFunctions.getRelativeFromAbsolute(basePoint, relativePoints.get("end"))
        );
    }

    private void drawLine(Graphics2D g, Structure structure, Point startPoint, Point endPoint) {
        initGraphic(g, structure);
        g.drawLine(
                startPoint.x,
                startPoint.y,
                endPoint.x,
                endPoint.y
        );
    }
}
