package core.service.scene.structure.pick;

import core.model.Structure;
import core.model.Text;
import java.awt.Graphics2D;

public class TextPicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Text text = (Text) structure;
        drawPickSquare(text, graphics2D);
    }
}
