package core.gui.sections.bottom;

import core.Config;
import core.controller.Controller;
import core.gui.sections.ElementsGroup;
import core.session.event.ColorButtonActionHandler;
import core.session.event.SliderChangeListener;
import core.utils.FormatFunctions;
import core.utils.sys.Machine;
import java.awt.Color;
import java.awt.Dimension;
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

public class BottomPanel extends JPanel implements ElementsGroup,
        MemoryInfoText, MousePositionText {
    private final ColorButtonActionHandler colorButtonActionHandler;
    private final Map<String, Controller> colorControllerMap;
    private final JLabel mousePositionText;
    private final JLabel memoryInfoText;

    public BottomPanel() {
        super(new FlowLayout(FlowLayout.LEFT, 30, 5));
        colorControllerMap = new HashMap<>();
        colorButtonActionHandler = new ColorButtonActionHandler(colorControllerMap);
        mousePositionText = new JLabel(
                String.format(Config.MOUSE_POSITION_PATTERN, 0, 0));
        memoryInfoText = new JLabel(
                String.format(Config.USAGE_MEMORY_PATTERN, "0/0"));
    }

    @Override
    public void create() {
        JPanel colors = new JPanel(new GridLayout(2, 3, 3, 3));
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
            button.setPreferredSize(new Dimension(18, 18));
            button.setBackground(colorButton.getColor());
            button.transferFocusBackward();
            button.setActionCommand(colorButton.getCommand());
            button.addActionListener(colorButtonActionHandler);
            colorControllerMap.put(colorButton.getCommand(), colorButton.getController());
            colors.add(button);
            buttonGroup.add(button);
        }
    }

    private void addMemoryInfoText() {
        add(memoryInfoText);
    }

    private void addMousePositionText() {
        add(mousePositionText);
    }

    private void addStrokeSlider() {
        JPanel strokeSliderPanel = new JPanel(new FlowLayout());
        strokeSliderPanel.setBackground(Color.WHITE);
        JSlider slider = new JSlider(1,15,1);
        slider.setBackground(Color.WHITE);
        slider.setPreferredSize(new Dimension(120, 20));
        slider.addChangeListener(new SliderChangeListener());
        strokeSliderPanel.add(new JLabel("Stroke width: "));
        strokeSliderPanel.add(slider);
        add(strokeSliderPanel);
    }

    @Override
    public void updateMousePosition(Point position) {
        mousePositionText.setText(String.format(Config.MOUSE_POSITION_PATTERN,
                (int) position.getX(), (int) position.getY()));
    }

    @Override
    public void updateMemoryInfoText(String used, String total) {
        String text = FormatFunctions.formatNumber(Machine.getUsedMemory())
                + " / "
                + FormatFunctions.formatNumber(Machine.getTotalMemory());
        memoryInfoText.setText(String.format(Config.USAGE_MEMORY_PATTERN, text));
    }

}
