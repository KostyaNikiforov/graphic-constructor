package core.utils;

import java.awt.Point;

public class MathFunctions {
    public static Point getEgePositionOfLine(Point p1, Point p2) {
        int x = (int) (p1.getX() - (p2.getX() - p1.getX()));
        int y = (int) (p1.getY() - (p2.getY() - p1.getY()));
        return new Point(x, y);
    }

    public static double getAngel(Point p1, Point p2) {
        double scope = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
        return Math.toDegrees(Math.atan(scope));
    }

    public static Point getPositionByAngleAndDistance(Point p, int distance, double angle) {
        int x = (int) (p.getX() + distance * Math.cos(angle));
        int y = (int) (p.getY() + distance * Math.sin(angle));
        return new Point(x, y);
    }

    public static Point getCenterPosition(Point p1, Point p2) {
        int x = (int) ((p1.getX() + p2.getX()) / 2);
        int y = (int) ((p1.getY() + p2.getY()) / 2);
        return new Point(x, y);
    }
}
