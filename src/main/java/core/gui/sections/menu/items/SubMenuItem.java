package core.gui.sections.menu.items;

import core.controller.Controller;

public class SubMenuItem extends Item {
    private Controller controller;

    public SubMenuItem(String name, Controller controller) {
        super(name);
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
