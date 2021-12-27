package core.gui;

import core.Config;
import core.gui.sections.ElementsGroup;
import core.gui.sections.bottom.BottomPanel;
import core.gui.sections.bottom.MemoryInfoText;
import core.gui.sections.bottom.MousePositionText;
import core.gui.sections.canvas.SceneCanvas;
import core.gui.sections.left.LeftToolPanel;
import core.gui.sections.menu.MainMenu;
import core.gui.sections.right.DynamicToolsPanel;
import core.gui.sections.right.RightSettingsPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;

public class Window extends JFrame {
    private final MainMenu menuBar;
    private final ElementsGroup bottomPanel;
    private final ElementsGroup leftPanel;
    private final ElementsGroup rightPanel;
    private final ElementsGroup sceneCanvas;
    private final Container contents;

    public Window(SceneCanvas sceneCanvas) {
        super(Config.TITLE);
        this.sceneCanvas = sceneCanvas;
        menuBar = new MainMenu(Config.MENU_ELEMENTS);
        contents = getContentPane();
        bottomPanel = new BottomPanel();
        leftPanel = new LeftToolPanel();
        rightPanel = new RightSettingsPanel();
    }

    public void create() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(Config.WINDOW_POSITION_X, Config.WINDOW_POSITION_Y);
        setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        addElements();
        setVisible(true);
    }

    private void addElements() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMenuBar();
        addLeftPanel();
        addBottomPanel();
        addRightSettingsPanel();
        addCanvas();
        setContentPane(contents);
    }

    private void addRightSettingsPanel() {
        rightPanel.create();
        contents.add((Component) rightPanel, BorderLayout.EAST);
    }

    private void addMenuBar() {
        menuBar.create();
        setJMenuBar(menuBar);
    }

    private void addBottomPanel() {
        bottomPanel.create();
        contents.add((Component) bottomPanel, BorderLayout.SOUTH);
    }

    private void addLeftPanel() {
        leftPanel.create();
        contents.add((Component) leftPanel, BorderLayout.WEST);
    }

    private void addCanvas() {
        sceneCanvas.create();
        contents.add((Component) sceneCanvas, BorderLayout.CENTER);
    }

    public MemoryInfoText getMemoryInfoContainer() {
        return (MemoryInfoText) bottomPanel;
    }

    public MousePositionText getMousePositionInfoContainer() {
        return (MousePositionText) bottomPanel;
    }

    public DynamicToolsPanel getDynamicToolsPanel() {
        return (DynamicToolsPanel) rightPanel;
    }

    public LeftToolPanel getLeftPanel() {
        return (LeftToolPanel) leftPanel;
    }
}
