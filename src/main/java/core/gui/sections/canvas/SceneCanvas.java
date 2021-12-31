package core.gui.sections.canvas;

import core.App;
import core.Config;
import core.gui.sections.ElementsGroup;
import core.model.Structure;
import core.service.scene.structure.processing.draw.DrawStrategy;
import core.service.scene.structure.processing.pick.PickStrategy;
import core.service.scene.structure.processing.strategy.StructureProcessingStrategy;
import core.session.event.MouseEventHandler;
import core.session.event.MouseMotionHandler;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class SceneCanvas extends Canvas implements ElementsGroup {
    private final DrawStrategy drawStrategy
            = (DrawStrategy) App.injector.getInstance(StructureProcessingStrategy.class);
    private final PickStrategy pickStrategy
            = (PickStrategy) App.injector.getInstance(StructureProcessingStrategy.class);

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
        drawStrategy.getStructureDrawer(structure.getCreatingMode()).draw(structure, graphics2D);
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

        pickStrategy.getStructurePicker(structure.getCreatingMode())
                .pickUp(structure, graphics2D);
    }
}
