package core.utils.sys;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;

public class Machine {
    private static final Runtime runtime = Runtime.getRuntime();
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static int getScreenHeight() {
        return (int) screenSize.getHeight();
    }

    public static int getScreenWidth() {
        return (int) screenSize.getWidth();
    }

    public static int getMouseX() {
        return MouseInfo.getPointerInfo().getLocation().x;
    }

    public static int getMouseY() {
        return MouseInfo.getPointerInfo().getLocation().y;
    }

    public static String getTotalMemory() {
        return String.valueOf(runtime.totalMemory());
    }

    public static String getFreeMemory() {
        return String.valueOf(runtime.freeMemory());
    }

    public static String getUsedMemory() {
        return String.valueOf(runtime.totalMemory() - runtime.freeMemory());
    }
}
