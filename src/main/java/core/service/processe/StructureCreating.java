package core.service.processe;

import core.App;
import core.session.Properties;
import java.awt.Point;

public class StructureCreating implements ProcessHandler {
    @Override
    public void finish(Point point) {
        Properties properties = App.getSession().getProperties();
        App.getSession().getSceneControl()
                .createNewStructure(properties.getStartPoint(), point);
    }
}
