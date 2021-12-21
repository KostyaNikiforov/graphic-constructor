package core.service.scene.structure.draw;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public class LineDrawer implements StructureDrawer {
    @Override
    public void draw(Structure structure, Graphics2D g) {
        Map<String, Point> relativePoints = structure.getRelativePoints();
        g.drawLine(
                relativePoints.get("start").x,
                relativePoints.get("start").y,
                relativePoints.get("end").x,
                relativePoints.get("end").y
        );
    }
}
