package core.gui.models.canvas;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import core.App;
import core.Config;
import core.gui.models.ElementsGroup;
import core.lib.Injector;
import core.model.Structure;
import core.service.scene.structure.draw.strategy.DrawStrategy;
import core.service.scene.structure.pick.strategy.PickStrategy;
import core.session.handlers.MouseEventHandler;
import core.session.handlers.MouseMotionHandler;

public class SceneCanvas extends Canvas implements ElementsGroup {
    private static final Injector injector = Injector.getInstance("core.service.scene.structure");
    private final DrawStrategy drawStrategy
            = (DrawStrategy) injector.getInstance(DrawStrategy.class);
    private final PickStrategy pickStrategy
            = (PickStrategy) injector.getInstance(PickStrategy.class);

    public void create() {
        setBackground(Config.CANVAS_BG_COLOR);
        addMouseListener(new MouseEventHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public void paint(Graphics g) {
        drawStructures(
                App.getSession().getSceneControl().getScene()
                        .getStructureContainer().getAllStructures()
        );
    }

    public void drawStructure(Structure structure, Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(structure.getStroke()));
        graphics2D.setColor(structure.getColor());
        drawStrategy.getStructureDrawer(structure.type).draw(structure, graphics2D);
    }

    private void drawStructures(List<Structure> structures) {
        Graphics2D graphics2D = (Graphics2D) getGraphics().create();
        for (Structure structure : structures) {
            drawStructure(structure, graphics2D);
            if (structure.equals(App.getSession().getProperties().getChosenStructure())) {
                pickUpStructure(structure, graphics2D);
            }
        }
    }

    private void pickUpStructure(Structure structure, Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(1));
        pickStrategy.getStructurePicker(structure.type).pickUp(structure, graphics2D);
    }
}
