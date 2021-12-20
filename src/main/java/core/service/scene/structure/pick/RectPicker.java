package core.service.scene.structure.pick;

import core.model.Rect;
import core.model.Structure;
import java.awt.Graphics2D;

public class RectPicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Rect rect = (Rect) structure;
        drawPickSquare(rect, graphics2D);
    }
}
