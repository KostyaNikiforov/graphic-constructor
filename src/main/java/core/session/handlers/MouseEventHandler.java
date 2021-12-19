package core.session.handlers;

import core.Config;
import core.controller.MouseController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class MouseEventHandler implements MouseListener {
    private static final int LEFT_BUTTON = 3;
    private static final int MIDDLE_BUTTON = 2;
    private static final int RIGHT_BUTTON = 1;
    private final Map<String, MouseController> controllerMap;

    {
        controllerMap = Config.MOUSE_CONTROLLER_MAP;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        MouseController mouseController = null;
        switch (mouseEvent.getButton()) {
            case LEFT_BUTTON:
                if (mouseEvent.getClickCount() == 2) {
                    mouseController = controllerMap.get("left_double_click");
                }
                break;
            case RIGHT_BUTTON:
                if (mouseEvent.getClickCount() == 2) {
                    mouseController = controllerMap.get("right_double_click");
                }
                break;
            case MIDDLE_BUTTON:
                System.out.println("middle");
                mouseController = controllerMap.get("middle_click");
                break;
            default:
                break;
        }
        if (mouseController != null) {
            mouseController.apply(mouseEvent.getPoint());
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == RIGHT_BUTTON) {
            controllerMap.get("right_press").apply(mouseEvent.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == RIGHT_BUTTON
                && mouseEvent.getClickCount() == 0) {
            controllerMap.get("right_release").apply(mouseEvent.getPoint());
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
