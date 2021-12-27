package core.service.scene.structure.processing.copy;

import core.model.Structure;
import javax.swing.JOptionPane;

public interface StructureCopyist<T extends Structure> {
    default Structure createCopy(T t) {
        JOptionPane.showMessageDialog(null, "You can't copy this element.");
        return null;
    }
}
