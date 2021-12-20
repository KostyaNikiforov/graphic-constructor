package core.controller.mouse;

import core.App;
import core.controller.MouseController;
import core.model.Structure;
import core.utils.MathFunctions;
import java.awt.Point;
import java.util.Map;
import java.util.Optional;

public class StructureMovingController implements MouseController {
    private static final int VISIBILITY_RADIUS = 15;

    @Override
    public void apply(Point point) {
        Structure chosenStructure = App.getSession().getProperties().getChosenStructure();
        if (chosenStructure == null) {
            return;
        }
        Map<String, Point> relativePoints
                = chosenStructure.getRelativePoints();
        Point centerPoint = chosenStructure.getCenterPosition();
        Optional<Point> optionalPoint = searchForClosestRelativePoint(relativePoints, centerPoint, point);
        if (optionalPoint.isPresent()) {
            optionalPoint.get().setLocation(MathFunctions.getRelativeFromAbsolute(centerPoint, point));
        } else {
            centerPoint.setLocation(point);
        }
        App.getSession().getSceneControl().update();
    }

    private Optional<Point> searchForClosestRelativePoint(Map<String, Point> relativePoints, Point centerPoint, Point point) {
        for (Map.Entry<String, Point> entry : relativePoints.entrySet()) {
            if (point.distance(MathFunctions.getAbsolutFromRelative(centerPoint, entry.getValue())) <= VISIBILITY_RADIUS) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
}
