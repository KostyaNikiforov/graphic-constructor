package core.gui.models.panels.bottom;

import java.awt.Color;
import core.controller.Controller;
import core.gui.models.panels.PanelButton;

public class ColorButton extends PanelButton {
    private Color color;

    public ColorButton(Color color, String command, Controller controller) {
        super(command, controller);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
