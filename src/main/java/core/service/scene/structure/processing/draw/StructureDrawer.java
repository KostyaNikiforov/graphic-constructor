package core.service.scene.structure.processing.draw;

import core.model.Structure;
import java.awt.Graphics2D;

public interface StructureDrawer<T extends Structure> extends AbstractDrawer<T> {
    void draw(T t, Graphics2D g);
}
