package core.service.convetror;

import core.model.Structure;
import java.util.List;
import javax.swing.JPanel;

public interface StructureToSettingComponents {
    List<JPanel> convert(Structure structure);
}
