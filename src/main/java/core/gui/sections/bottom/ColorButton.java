package core.gui.sections.bottom;

import core.controller.Controller;
import core.gui.sections.PanelButton;
import java.awt.Color;

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
