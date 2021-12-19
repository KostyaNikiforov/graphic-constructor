package core.gui.models.panels;

import core.controller.Controller;

public class PanelButton {
    private String command;
    private Controller controller;

    public PanelButton(String command, Controller controller) {
        this.command = command;
        this.controller = controller;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
