package core.session;

import core.App;
import core.Config;
import core.model.Structure;
import core.session.enums.CreatingMode;
import java.awt.Point;

public class Properties {
    private CreatingMode creatingMode;
    private int currentStroke;
    private Structure chosenStructure;
    private Point startPoint;

    {
        creatingMode = Config.DEFAULT_CREATING_MODE;
        currentStroke = Config.DEFAULT_STROKE;
        chosenStructure = null;
    }

    public CreatingMode getCreatingMode() {
        return creatingMode;
    }

    public void setCreatingMode(CreatingMode creatingMode) {
        this.creatingMode = creatingMode;
        App.getSession().getMainWindow()
                .getLeftPanel().updateChosenTool(creatingMode);
    }

    public int getCurrentStrokeWidth() {
        return currentStroke;
    }

    public void setCurrentStroke(int currentStroke) {
        this.currentStroke = currentStroke;
    }

    public Structure getChosenStructure() {
        return chosenStructure;
    }

    public void setChosenStructure(Structure chosenStructure) {
        this.chosenStructure = chosenStructure;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

}
