package core.service.scene.structure.pick;

import core.model.Structure;
import java.awt.Graphics2D;

public class LinePicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        drawPickSquare(structure, graphics2D);
    }
}
