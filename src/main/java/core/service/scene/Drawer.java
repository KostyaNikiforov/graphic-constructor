package core.service.scene;

import core.App;
import core.Config;
import core.gui.models.canvas.SceneCanvas;
import core.model.Structure;
import core.service.scene.structure.Extracting;
import core.service.scene.structure.create.strategy.StructureCreateStrategy;
import core.session.enums.CreatingMode;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Drawer implements Highlighting, Creating, Extracting {
    private StructureCreateStrategy structureCreateStrategy;
    private SceneCanvas sceneCanvas;

    public Drawer(SceneCanvas sceneCanvas, StructureCreateStrategy structureCreateStrategy) {
        this.structureCreateStrategy = structureCreateStrategy;
        this.sceneCanvas = sceneCanvas;
    }

    @Override
    public void drawHighlightingRect(Point startPoint, Point endPoint) {
        Graphics2D g = (Graphics2D) sceneCanvas.getGraphics().create();
        sceneCanvas.update(g);
        g.setStroke(Config.BASIC_STROKE);
        g.setColor(Color.GREEN);
        g.drawRect(
                startPoint.getX() < endPoint.getX()
                        ? (int) startPoint.getX()
                        : (int) endPoint.getX(),
                startPoint.getY() < endPoint.getY()
                        ? (int) startPoint.getY()
                        : (int) endPoint.getY(),
                (int) Math.abs(endPoint.getX() - startPoint.getX()),
                (int) Math.abs(endPoint.getY() - startPoint.getY())
        );
    }

    @Override
    public void drawExtractingRect(Point startPoint, Point endPoint) {
        Graphics2D g = (Graphics2D) sceneCanvas.getGraphics().create();
        sceneCanvas.update(g);
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                0, new float[]{9}, 0));
        g.setColor(Color.DARK_GRAY);
        g.drawRect(
                startPoint.getX() < endPoint.getX()
                        ? (int) startPoint.getX()
                        : (int) endPoint.getX(),
                startPoint.getY() < endPoint.getY()
                        ? (int) startPoint.getY()
                        : (int) endPoint.getY(),
                (int) Math.abs(endPoint.getX() - startPoint.getX()),
                (int) Math.abs(endPoint.getY() - startPoint.getY())
        );
    }

    @Override
    public void drawCreatingStructure(Point startPoint, Point endPoint) {
        CreatingMode creatingMode = App.getSession().getProperties().getCreatingMode();
        Graphics2D g = (Graphics2D) sceneCanvas.getGraphics().create();
        sceneCanvas.update(g);
        Structure structure = structureCreateStrategy
                .getStructureCreator(creatingMode)
                .create(startPoint, endPoint);
        sceneCanvas.drawStructure(structure, g);
    }
}
