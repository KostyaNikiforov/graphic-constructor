package core.gui.models.panels.left;

import core.Config;
import core.controller.Controller;
import core.gui.models.ElementsGroup;
import core.session.enums.CreatingMode;
import core.session.event.PanelButtonActionHandler;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

public class LeftToolPanel extends JToolBar implements ElementsGroup {
    private final PanelButtonActionHandler buttonActionHandler;
    private final Map<String, Controller> panelControllerMap;

    public LeftToolPanel() {
        super(JToolBar.VERTICAL);
        panelControllerMap = new HashMap<>();
        buttonActionHandler = new PanelButtonActionHandler(panelControllerMap);
    }

    public void create() {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        for (LeftPanelButton leftPanelButton : Config.LEFT_PANEL_BUTTONS) {
            JToggleButton button = new JToggleButton();
            button.setBackground(Color.GRAY);
            if (leftPanelButton.getIcon() != null) {
                button.setIcon(leftPanelButton.getIcon());
            } else {
                button.setText(leftPanelButton.getText());
            }
            button.setActionCommand(leftPanelButton.getCommand());
            button.addActionListener(buttonActionHandler);
            panelControllerMap.put(leftPanelButton.getCommand(), leftPanelButton.getController());
            addButton(button);
        }
        setBackground(Config.LEFT_PANEL_BG_COLOR);
    }

    private void addButton(JToggleButton button) {
        add(button);
    }

    public void updateChosenTool(CreatingMode creatingMode) {
        for (Component component : getComponents()) {
            JToggleButton button = (JToggleButton) component;
            button.setSelected(button.getActionCommand().equals(creatingMode.toString()));
        }
    }
}
