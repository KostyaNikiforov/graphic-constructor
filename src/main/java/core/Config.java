package core;

import core.controller.MouseController;
import core.controller.SettingController;
import core.controller.colors.BlackController;
import core.controller.colors.BlueController;
import core.controller.colors.DarkGreyController;
import core.controller.colors.GreenController;
import core.controller.colors.RedController;
import core.controller.colors.WhiteController;
import core.controller.menu.ClearController;
import core.controller.menu.RedoController;
import core.controller.menu.TestController;
import core.controller.menu.UndoController;
import core.controller.mouse.LeftDoubleClickController;
import core.controller.mouse.MiddleClickController;
import core.controller.mouse.RightDoubleClickController;
import core.controller.mouse.RightPressController;
import core.controller.mouse.RightReleaseController;
import core.controller.panel.CircleModeController;
import core.controller.panel.HighlightModeController;
import core.controller.panel.LineModeButton;
import core.controller.panel.MoveModeController;
import core.controller.panel.RectModeController;
import core.controller.setting.HeightController;
import core.controller.setting.RadiusController;
import core.controller.setting.StrokeController;
import core.controller.setting.WidthController;
import core.controller.setting.XController;
import core.controller.setting.YController;
import core.gui.models.menu.items.MenuItem;
import core.gui.models.menu.items.SubMenuItem;
import core.gui.models.panels.bottom.ColorButton;
import core.gui.models.panels.left.LeftPanelButton;
import core.service.create.strategy.creators.CircleCreator;
import core.service.create.strategy.creators.LineCreator;
import core.service.create.strategy.creators.RectCreator;
import core.service.create.strategy.creators.StructureCreator;
import core.session.enums.CreatingMode;
import core.utils.sys.Machine;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class Config {
    public static final int WINDOW_HEIGHT = (int) (Machine.getScreenHeight() * 0.7);
    public static final int WINDOW_WIDTH = (int) (Machine.getScreenWidth() * 0.7);
    public static final int WINDOW_POSITION_X =
            Machine.getScreenWidth() / 2 - Config.WINDOW_WIDTH / 2;
    public static final int WINDOW_POSITION_Y =
            Machine.getScreenHeight() / 2 - Config.WINDOW_HEIGHT / 2;
    public static final String TITLE = "Pain Extreme 3000";
    public static final String MOUSE_POSITION_PATTERN = "X: %d; Y: %d;";
    public static final String USAGE_MEMORY_PATTERN = "Usage memory: %s";
    public static final Color LEFT_PANEL_BG_COLOR = Color.DARK_GRAY;
    public static final Color RIGHT_PANEL_BG_COLOR = Color.WHITE;
    public static final Color BOTTOM_PANEL_BG_COLOR = Color.WHITE;
    public static final Color PANEL_BG_COLOR = Color.GRAY;
    public static final Color CANVAS_BG_COLOR = Color.GRAY;
    public static final CreatingMode DEFAULT_CREATING_MODE = CreatingMode.HIGHLIGHTING;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    public static final int DEFAULT_STROKE = 2;
    public static final BasicStroke BASIC_STROKE
            = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
            0, new float[]{9}, 0);
    public static final Map<CreatingMode, StructureCreator> STRUCTURE_CREATOR_MAP
            = new HashMap<>();
    public static final Map<String, MouseController> MOUSE_CONTROLLER_MAP
            = new HashMap<>();
    public static final Map<String, SettingController> STRUCTURE_SETTING_CONTROLLER_MAP
            = new HashMap<>();

    public static final MenuItem[] MENU_ELEMENTS = new MenuItem[] {
            new MenuItem("Edit", new SubMenuItem[] {
                    new SubMenuItem("Undo", new UndoController()),
                    new SubMenuItem("Redo", new RedoController()),
                    new SubMenuItem("Clear", new ClearController())
            }),
            new MenuItem("Tests", new SubMenuItem[] {
                    new SubMenuItem("Test 1", new TestController())
            }),
    };

    public static final LeftPanelButton[] LEFT_PANEL_BUTTONS = new LeftPanelButton[] {
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/hand_icon_25x25.png"),
                    "move", new MoveModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/dashed_rect_icon_25x25.png"),
                    "Highlight", new HighlightModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/line_icon_25x25.png"),
                    "line", new LineModeButton()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/circle_icon_25x25.png"),
                    "circle", new CircleModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/rect_icon_25x25.png"),
                    "rect", new RectModeController())
    };

    public static final ColorButton[] COLOR_BUTTONS = new ColorButton[] {
            new ColorButton(Color.RED, "red", new RedController()),
            new ColorButton(Color.GREEN, "green", new GreenController()),
            new ColorButton(Color.BLUE, "blue", new BlueController()),
            new ColorButton(Color.BLACK, "black", new BlackController()),
            new ColorButton(Color.DARK_GRAY, "dark_grey", new DarkGreyController()),
            new ColorButton(Color.WHITE, "white", new WhiteController()),
    };

    static {
        fillUpStructureCreatorMap();
        fillUpMouseControllerMap();
        fillUpStructureSettingControllerMap();
    }

    private static void fillUpStructureSettingControllerMap() {
        STRUCTURE_SETTING_CONTROLLER_MAP.put("radius", new RadiusController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("height", new HeightController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("width", new WidthController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("x", new XController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("y", new YController());
        STRUCTURE_SETTING_CONTROLLER_MAP.put("stroke", new StrokeController());
    }

    private static void fillUpMouseControllerMap() {
        MOUSE_CONTROLLER_MAP.put("left_double_click", new LeftDoubleClickController());
        MOUSE_CONTROLLER_MAP.put("right_double_click", new RightDoubleClickController());
        MOUSE_CONTROLLER_MAP.put("right_press", new RightPressController());
        MOUSE_CONTROLLER_MAP.put("right_release", new RightReleaseController());
        MOUSE_CONTROLLER_MAP.put("middle_click", new MiddleClickController());
    }

    private static void fillUpStructureCreatorMap() {
        STRUCTURE_CREATOR_MAP.put(CreatingMode.CIRCLE, new CircleCreator());
        STRUCTURE_CREATOR_MAP.put(CreatingMode.LINE, new LineCreator());
        STRUCTURE_CREATOR_MAP.put(CreatingMode.RECT, new RectCreator());
    }
}
