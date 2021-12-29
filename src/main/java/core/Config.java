package core;

import core.controller.colors.BlackController;
import core.controller.colors.BlueController;
import core.controller.colors.DarkGreyController;
import core.controller.colors.GreenController;
import core.controller.colors.RedController;
import core.controller.colors.WhiteController;
import core.controller.menu.ClearController;
import core.controller.menu.UndoController;
import core.controller.mouse.LeftDoubleClickController;
import core.controller.mouse.MiddleClickController;
import core.controller.mouse.RightDoubleClickController;
import core.controller.mouse.RightPressController;
import core.controller.mouse.RightReleaseController;
import core.controller.panel.CircleModeController;
import core.controller.panel.HighlightModeController;
import core.controller.panel.ImageExtractModeController;
import core.controller.panel.LayerModeController;
import core.controller.panel.LineModeButton;
import core.controller.panel.MoveModeController;
import core.controller.panel.PictureModeController;
import core.controller.panel.RectModeController;
import core.controller.panel.TextModeController;
import core.controller.setting.HeightController;
import core.controller.setting.RadiusController;
import core.controller.setting.StrokeController;
import core.controller.setting.TextContentController;
import core.controller.setting.TextSizeContentController;
import core.controller.setting.WidthController;
import core.controller.setting.XController;
import core.controller.setting.YController;
import core.gui.sections.bottom.ColorButton;
import core.gui.sections.left.LeftPanelButton;
import core.gui.sections.menu.items.MenuItem;
import core.gui.sections.menu.items.SubMenuItem;
import core.session.enums.CreatingMode;
import core.utils.sys.Machine;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Config {
    /** Window properties */
    public static final int WINDOW_HEIGHT = (int) (Machine.getScreenHeight() * 0.7);
    public static final int WINDOW_WIDTH = (int) (Machine.getScreenWidth() * 0.7);
    public static final int WINDOW_POSITION_X =
            Machine.getScreenWidth() / 2 - Config.WINDOW_WIDTH / 2;
    public static final int WINDOW_POSITION_Y =
            Machine.getScreenHeight() / 2 - Config.WINDOW_HEIGHT / 2;
    public static final String TITLE = "Graphic constructor 1.0";

    /** Design style */
    public static final Color LEFT_PANEL_BG_COLOR = Color.DARK_GRAY;
    public static final Color RIGHT_PANEL_BG_COLOR = Color.WHITE;
    public static final Color BOTTOM_PANEL_BG_COLOR = Color.WHITE;
    public static final Color CANVAS_BG_COLOR = Color.GRAY;

    /** String patterns*/
    public static final String MOUSE_POSITION_PATTERN = "Mouse position: X: %d; Y: %d;";
    public static final String USAGE_MEMORY_PATTERN = "Usage memory: %s";

    /** Default values*/
    public static final String DEFAULT_IMAGE_FILE_PATH = "src/main/resources/image.png";
    public static final String DEFAULT_TEXT_CONTENT = "Text";
    public static final CreatingMode DEFAULT_CREATING_MODE = CreatingMode.HIGHLIGHTING;
    public static final int DEFAULT_STROKE = 2;

    /** Processing properties */
    public static final int MODIFY_POINTS_VISIBILITY_RADIUS = 15;
    public static final int CLONE_SHIFT_DISTANCE = 25;
    public static final BasicStroke BASIC_STROKE
            = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
            0, new float[]{9}, 0);

    /** Manu */
    public static final MenuItem[] MENU_ELEMENTS = new MenuItem[] {
            new MenuItem("Edit", new SubMenuItem[] {
                    new SubMenuItem("Remove last", new UndoController()),
                    new SubMenuItem("Clear", new ClearController())
            }),
    };

    /** Left tools panel
     * Accepts Image or String object as content parameter.
     * */
    public static final LeftPanelButton[] LEFT_PANEL_BUTTONS = new LeftPanelButton[] {
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/camera_icon_25x25.png"),
                    CreatingMode.IMAGE_EXTRACT.toString(), new ImageExtractModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/hand_icon_25x25.png"),
                    CreatingMode.MOVING.toString(), new MoveModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/dashed_rect_icon_25x25.png"),
                    CreatingMode.HIGHLIGHTING.toString(), new HighlightModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/line_icon_25x25.png"),
                    CreatingMode.LINE.toString(), new LineModeButton()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/circle_icon_25x25.png"),
                    CreatingMode.CIRCLE.toString(), new CircleModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/rect_icon_25x25.png"),
                    CreatingMode.RECT.toString(), new RectModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/text_icon_25x25.png"),
                    CreatingMode.TEXT.toString(), new TextModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/layer_icon_25x25.png"),
                    CreatingMode.LAYER.toString(), new LayerModeController()),
            new LeftPanelButton(
                    new ImageIcon("src/main/resources/icons/picture_icon_25x25.png"),
                    CreatingMode.PICTURE.toString(), new PictureModeController())
    };

    /** Bottom panels colors list.*/
    public static final ColorButton[] COLOR_BUTTONS = new ColorButton[] {
            new ColorButton(Color.RED, "red", new RedController()),
            new ColorButton(Color.GREEN, "green", new GreenController()),
            new ColorButton(Color.BLUE, "blue", new BlueController()),
            new ColorButton(Color.BLACK, "black", new BlackController()),
            new ColorButton(Color.DARK_GRAY, "dark_grey", new DarkGreyController()),
            new ColorButton(Color.WHITE, "white", new WhiteController()),
    };
}
