package core.service.scene.structure.processing;

import core.App;
import core.Config;
import core.lib.Service;
import core.model.Line;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

@Service
public class LineProcessing implements StructureProcessing<Line> {
    @Override
    public Line create(Point startPosition, Point endPosition) {
        Line line = new Line(
                MathFunctions.getCenterPosition(startPosition, endPosition),
                startPosition,
                endPosition
        );
        line.setColor(line.getColor());
        line.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return line;
    }

    @Override
    public void relativeDraw(Line line, Graphics2D g, Point basePoint) {
        Map<String, Point> relativePoints = line.getRelativePoints();
        drawLine(
                g,
                line,
                MathFunctions.getRelativeFromAbsolute(basePoint, relativePoints.get("start")),
                MathFunctions.getRelativeFromAbsolute(basePoint, relativePoints.get("end"))
        );
    }

    @Override
    public void draw(Line line, Graphics2D g) {
        Map<String, Point> relativePoints = line.getRelativePoints();
        drawLine(
                g,
                line,
                relativePoints.get("start"),
                relativePoints.get("end")
        );
    }

    private void drawLine(Graphics2D g, Line line, Point startPoint, Point endPoint) {
        initGraphic(g, line);
        g.drawLine(
                startPoint.x,
                startPoint.y,
                endPoint.x,
                endPoint.y
        );
    }

    @Override
    public Structure createCopy(Line line) {
        Map<String, Point> relativePoints = line.getRelativePoints();
        Point centerPoint = line.getCenterPosition();
        Point startPoint = relativePoints.get("start");
        Point endPoint = relativePoints.get("end");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Line newLine = new Line(
                new Point(centerPoint.x + shift, centerPoint.y + shift),
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        newLine.setColor(line.getColor());
        newLine.setStrokeWidth(line.getStrokeWidth());
        return newLine;
    }
}
