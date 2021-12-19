package core.service.scene.structure.pick.strategy;

import java.awt.Graphics2D;
import java.awt.Point;
import core.model.Structure;
import core.service.scene.structure.pick.StructurePicker;

public class CirclePicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        drawPickSquare(new Point[] {structure.getCenterPosition()}, graphics2D);
    }
}
