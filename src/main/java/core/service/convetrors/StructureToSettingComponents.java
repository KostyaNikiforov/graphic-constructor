package core.service.convetrors;

import java.util.List;
import javax.swing.JPanel;
import core.model.Structure;

public interface StructureToSettingComponents {
    List<JPanel> convert(Structure structure);
}
