package core.session.handlers;

import core.controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PanelButtonActionHandler implements ActionListener {
    private final Map<String, Controller> controllerMap;

    public PanelButtonActionHandler(Map<String, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controllerMap.getOrDefault(e.getActionCommand(),
                () -> System.out.println("Unknown button pushed")).apply();
    }
}
