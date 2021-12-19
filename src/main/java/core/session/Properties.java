package core.session;

import core.Config;
import core.model.Structure;
import core.session.enums.CreatingMode;
import java.awt.Color;
import java.awt.Point;

public class Properties {
    private CreatingMode creatingMode;
    private Color currentColor;
    private int currentStroke;
    private Structure chosenStructure;
    private Point startPoint;
    private Point[] pickedUpPints;

    {
        creatingMode = Config.DEFAULT_CREATING_MODE;
        currentColor = Config.DEFAULT_COLOR;
        currentStroke = Config.DEFAULT_STROKE;
        chosenStructure = null;
        pickedUpPints = null;
    }

    public CreatingMode getCreatingMode() {
        return creatingMode;
    }

    public void setCreatingMode(CreatingMode creatingMode) {
        this.creatingMode = creatingMode;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public int getCurrentStroke() {
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

    public Point[] getPickedUpPints() {
        return pickedUpPints;
    }

    public void setPickedUpPints(Point[] pickedUpPints) {
        this.pickedUpPints = pickedUpPints;
    }
}
