package core.service.scene.structure.pick;

import java.awt.Graphics2D;
import java.awt.Point;
import core.model.Rect;
import core.model.Structure;

public class RectPicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Rect rect = (Rect) structure;
        drawPickSquare(new Point[] {rect.getCenterPosition()}, graphics2D);
    }
}
