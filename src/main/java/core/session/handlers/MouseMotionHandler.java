package core.session.handlers;

import core.App;
import core.controller.MouseController;
import core.controller.mouse.HighlightingController;
import core.controller.mouse.MouseMovingController;
import core.controller.mouse.StructureCreatingController;
import core.controller.mouse.StructureMovingController;
import core.session.enums.CreatingMode;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class MouseMotionHandler implements java.awt.event.MouseMotionListener {
    private final MouseController highlightingController;
    private final MouseController structureMovingController;
    private final MouseController structureCreatingController;
    private final MouseController mouseMovingController;

    public MouseMotionHandler() {
        highlightingController = new HighlightingController();
        structureCreatingController = new StructureCreatingController();
        structureMovingController = new StructureMovingController();
        mouseMovingController = new MouseMovingController();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        CreatingMode creatingMode = App.getSession().getProperties().getCreatingMode();
        Point point = mouseEvent.getPoint();
        switch (creatingMode) {
            case HIGHLIGHTING:
                highlightingController.apply(point);
                break;
            case MOVING:
                structureMovingController.apply(point);
                break;
            default:
                structureCreatingController.apply(point);
                break;
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseMovingController.apply(mouseEvent.getPoint());
    }
}
