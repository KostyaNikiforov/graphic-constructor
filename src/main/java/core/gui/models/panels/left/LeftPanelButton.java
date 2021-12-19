package core.gui.models.panels.left;

import core.controller.Controller;
import core.gui.models.panels.PanelButton;
import javax.swing.Icon;

public class LeftPanelButton extends PanelButton {
    private String text;
    private Icon icon;

    public LeftPanelButton(String command, Controller controller) {
        super(command, controller);
    }

    public LeftPanelButton(String text, String command, Controller controller) {
        this(command, controller);
        this.text = text;
    }

    public LeftPanelButton(Icon icon, String command, Controller controller) {
        this(command, controller);
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
