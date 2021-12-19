package core.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import core.Config;
import core.gui.models.ElementsGroup;
import core.gui.models.canvas.SceneCanvas;
import core.gui.models.menu.MainMenu;
import core.gui.models.panels.bottom.BottomPanel;
import core.gui.models.panels.bottom.MemoryInfoText;
import core.gui.models.panels.bottom.MousePositionText;
import core.gui.models.panels.left.LeftToolPanel;
import core.gui.models.panels.right.Autocomplete;
import core.gui.models.panels.right.Closeable;
import core.gui.models.panels.right.RightSettingsPanel;

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

    public Autocomplete getAutocompleteRightPanel() {
        return (Autocomplete) rightPanel;
    }

    public Closeable getCloseableRightPanel() {
        return (Closeable) rightPanel;
    }
}
