package core.model;

import core.Config;
import core.model.type.StructureType;
import java.awt.Font;
import java.awt.Point;

public class Text extends Structure {
    private String content;
    private int size;

    public Text(Point centerPosition, Point startPoint, Point endPoint) {
        super(centerPosition, StructureType.TEXT);
        content = Config.DEFAULT_TEXT_CONTENT;
        relativePoints.put("start", startPoint);
        relativePoints.put("end", endPoint);
    }

    public int getSize() {
        return Math.abs(relativePoints.get("end").y - (relativePoints.get("start").y));
    }

    public void setSize() {
        // TODO
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Font getFont() {
        return new Font(Font.DIALOG, Font.PLAIN, getSize());
    }

    @Override
    public boolean isInside(Point point) {
        return relativePoints.get("start").x < point.getX()
                && relativePoints.get("start").y < point.getY()
                && relativePoints.get("end").x > point.getX()
                && relativePoints.get("end").y > point.getY();
    }
}
