package core.service.scene.structure.processing;

import core.App;
import core.Config;
import core.lib.Service;
import core.model.Rect;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

@Service
public class RectProcessing implements StructureProcessing<Rect> {
    @Override
    public Rect create(Point startPosition, Point endPosition) {
        Point centerPosition = MathFunctions.getCenterPosition(startPosition, endPosition);
        Rect rect = new Rect(
                centerPosition,
                startPosition,
                endPosition
        );
        rect.setColor(rect.getColor());
        rect.setStrokeWidth(App.getSession().getProperties().getCurrentStrokeWidth());
        return rect;
    }

    @Override
    public void relativeDraw(Rect rect, Graphics2D g, Point basePoint) {
        Point startPoint = MathFunctions
                .getRelativeFromAbsolute(basePoint, rect.getRelativePoints().get("start"));
        drawRect(g, rect, startPoint);
    }

    @Override
    public void draw(Rect rect, Graphics2D g) {
        drawRect(g, rect, rect.getRelativePoints().get("start"));
    }

    private void drawRect(Graphics2D g, Rect rect, Point startPoint) {
        initGraphic(g, rect);
        g.drawRect(
                startPoint.x,
                startPoint.y,
                rect.getWidth(),
                rect.getHeight()
        );
    }

    @Override
    public Structure createCopy(Rect rect) {
        Map<String, Point> relativePoints = rect.getRelativePoints();
        Point centerPoint = rect.getCenterPosition();
        Point startPoint = relativePoints.get("start");
        Point endPoint = relativePoints.get("end");
        int shift = Config.CLONE_SHIFT_DISTANCE;
        Rect newRect = new Rect(
                new Point(centerPoint.x + shift, centerPoint.y + shift),
                new Point(startPoint.x + shift, startPoint.y + shift),
                new Point(endPoint.x + shift, endPoint.y + shift)
        );
        newRect.setColor(rect.getColor());
        newRect.setStrokeWidth(rect.getStrokeWidth());
        return newRect;
    }
}
