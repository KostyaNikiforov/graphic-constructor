package core.session.handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import core.controller.Controller;

public class ColorButtonActionHandler implements ActionListener {
    private final Map<String, Controller> controllerMap;

    public ColorButtonActionHandler(Map<String, Controller> controllerMap) {
        this.controllerMap = controllerMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controllerMap.getOrDefault(e.getActionCommand(),
                () -> System.out.println("Unknown color button pushed")).apply();
    }
}
