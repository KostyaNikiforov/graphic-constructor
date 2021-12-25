package core.service.processe;

import core.App;
import java.awt.Point;

public interface ProcessHandler {
    default void start(Point point) {
        App.getSession().getProperties().setStartPoint(point);
    }
    
    void finish(Point point);
}
