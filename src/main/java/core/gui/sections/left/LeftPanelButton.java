package core.gui.sections.left;

import core.controller.Controller;
import core.gui.sections.PanelButton;
import javax.swing.Icon;

public class LeftPanelButton extends PanelButton {
    private String text;
    private Icon icon;

    public LeftPanelButton(String command, Controller controller) {
        super(command, controller);
    }

    public LeftPanelButton(String content, String command, Controller controller) {
        this(command, controller);
        this.text = content;
    }

    public LeftPanelButton(Icon content, String command, Controller controller) {
        this(command, controller);
        this.icon = content;
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
