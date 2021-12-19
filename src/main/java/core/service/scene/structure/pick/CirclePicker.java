package core.service.scene.structure.pick;

import core.model.Structure;
import java.awt.Graphics2D;
import java.awt.Point;

public class CirclePicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        drawPickSquare(new Point[] {structure.getCenterPosition()}, graphics2D);
    }
}
