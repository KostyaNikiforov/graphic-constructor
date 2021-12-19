package core.gui.models.panels.left;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import core.Config;
import core.controller.Controller;
import core.gui.models.ElementsGroup;
import core.session.handlers.PanelButtonActionHandler;

public class LeftToolPanel extends JToolBar implements ElementsGroup {
    private final PanelButtonActionHandler buttonActionHandler;
    private final Map<String, Controller> panelControllerMap;
    private final ButtonGroup buttonGroup;

    public LeftToolPanel() {
        super(JToolBar.VERTICAL);
        panelControllerMap = new HashMap<>();
        buttonActionHandler = new PanelButtonActionHandler(panelControllerMap);
        buttonGroup = new ButtonGroup();
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
            buttonGroup.add(button);
            add(button);
        }
        setBackground(Config.LEFT_PANEL_BG_COLOR);
    }
}
