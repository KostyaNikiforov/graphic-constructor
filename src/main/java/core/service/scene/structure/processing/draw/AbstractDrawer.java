package core.service.scene.structure.processing.draw;

import core.model.Structure;
import java.awt.BasicStroke;
import java.awt.Graphics2D;

public interface AbstractDrawer<T extends Structure> {
    default void initGraphic(Graphics2D graphics2D, T t) {
        graphics2D.setStroke(new BasicStroke(t.getStrokeWidth()));
        graphics2D.setColor(t.getColor());
    }
}
