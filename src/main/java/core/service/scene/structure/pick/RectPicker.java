package core.service.scene.structure.pick;

import core.App;
import core.model.Rect;
import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public class RectPicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Rect rect = (Rect) structure;
        Point[] points = new Point[] {
                rect.getCenterPosition(), rect.getStartPoint(), rect.getEndPoint()
        };
        App.getSession().getProperties().setPickedUpPints(points);
        drawPickSquare(points, graphics2D);
    }
}
