package core.service.scene.structure.pick;

import core.model.Picture;
import core.model.Structure;
import java.awt.Graphics2D;

public class PicturePicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Picture picture = (Picture) structure;
        drawPickSquare(picture, graphics2D);
    }
}
