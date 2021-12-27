package core.service.scene.structure.pick;

import core.model.Layer;
import core.model.Structure;
import java.awt.Graphics2D;

public class LayerPicker implements StructurePicker {
    @Override
    public void pickUp(Structure structure, Graphics2D graphics2D) {
        Layer layer = (Layer) structure;
        drawPickSquare(layer, graphics2D);
    }
}
