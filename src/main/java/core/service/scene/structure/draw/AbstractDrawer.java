package core.service.scene.structure.draw;

import core.model.Structure;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

public interface AbstractDrawer {
    default void initGraphic(Graphics2D graphics2D, Structure structure) {
        graphics2D.setStroke(new BasicStroke(structure.getStrokeWidth()));
        graphics2D.setColor(structure.getColor());
    }
}
