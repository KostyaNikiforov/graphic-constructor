package core.gui.models.panels.right;

import core.App;
import core.Config;
import core.gui.models.ElementsGroup;
import core.utils.sys.Machine;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class RightSettingsPanel extends JPanel implements ElementsGroup, Autocomplete, Closeable {
    public RightSettingsPanel() {
        super(new GridLayout(20, 0, 15, 5));
    }

    @Override
    public void create() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.DARK_GRAY));
        setBackground(Config.RIGHT_PANEL_BG_COLOR);
    }

    @Override
    public void fillUp(List<JPanel> components) {
        removeAll();
        for (JPanel panel : components) {
            add(panel);
        }
        App.getSession().getMainWindow()
                .getMemoryInfoContainer()
                .updateMemoryInfoText(Machine.getUsedMemory(), Machine.getTotalMemory());
    }

    @Override
    public void close() {
        setVisible(false);
    }

    @Override
    public void open() {
        setVisible(true);
    }

    @Override
    public boolean isClosed() {
        return isVisible();
    }
}
