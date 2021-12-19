package core.gui.models.panels.bottom;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import core.Config;
import core.controller.Controller;
import core.gui.models.ElementsGroup;
import core.session.handlers.ColorButtonActionHandler;
import core.session.handlers.SliderChangeListener;
import core.utils.FormatFunctions;
import core.utils.sys.Machine;

public class BottomPanel extends JPanel implements ElementsGroup,
        MemoryInfoText, MousePositionText {
    private final ColorButtonActionHandler colorButtonActionHandler;
    private final Map<String, Controller> colorControllerMap;
    private final JLabel mousePositionText;
    private final JLabel memoryInfoText;

    public BottomPanel() {
        super(new FlowLayout(FlowLayout.LEFT, 25, 5));
        colorControllerMap = new HashMap<>();
        colorButtonActionHandler = new ColorButtonActionHandler(colorControllerMap);
        mousePositionText = new JLabel(
                String.format(Config.MOUSE_POSITION_PATTERN, 0, 0));
        memoryInfoText = new JLabel(
                String.format(Config.USAGE_MEMORY_PATTERN, "0/0"));
    }

    @Override
    public void create() {
        JPanel colors = new JPanel(new GridLayout(2, 3, 10, 10));
        colors.setBackground(Config.BOTTOM_PANEL_BG_COLOR);
        addColorsToColorsToolBar(colors);
        add(colors);
        addStrokeSlider();
        addMousePositionText();
        addMemoryInfoText();
        setBackground(Config.BOTTOM_PANEL_BG_COLOR);
    }

    private void addColorsToColorsToolBar(JPanel colors) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (ColorButton colorButton : Config.COLOR_BUTTONS) {
            JToggleButton button = new JToggleButton();
            button.setBackground(colorButton.getColor());
            button.transferFocusBackward();
            button.setActionCommand(colorButton.getCommand());
            button.addActionListener(colorButtonActionHandler);
            colorControllerMap.put(colorButton.getCommand(), colorButton.getController());
            buttonGroup.add(button);
            colors.add(button);
        }
    }

    private void addMemoryInfoText() {
        add(memoryInfoText);
    }

    private void addMousePositionText() {
        add(mousePositionText);
    }

    private void addStrokeSlider() {
        JSlider slider = new JSlider(1,15,1);
        slider.addChangeListener(new SliderChangeListener());
        add(slider);
    }

    @Override
    public void updateMousePosition(Point position) {
        mousePositionText.setText(String.format(Config.MOUSE_POSITION_PATTERN,
                (int) position.getX(), (int) position.getY()));
    }

    @Override
    public void updateMemoryInfoText(String used, String total) {
        String text = FormatFunctions.formatNumber(Machine.getUsedMemory())
                + "/"
                + FormatFunctions.formatNumber(Machine.getTotalMemory());
        memoryInfoText.setText(String.format(Config.USAGE_MEMORY_PATTERN, text));
    }

}
