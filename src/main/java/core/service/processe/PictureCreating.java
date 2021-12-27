package core.service.processe;

import core.App;
import core.gui.dialog.file.FileDialogImpl;
import core.gui.dialog.file.FileLoader;
import core.model.Picture;
import core.model.Structure;
import core.session.Properties;
import java.awt.Point;
import javax.swing.JFileChooser;

public class PictureCreating implements ProcessHandler {
    private final FileLoader fileLoader = new FileDialogImpl();

    @Override
    public void finish(Point point) {
        int result = fileLoader.openLoadDialogWindow();
        if (result == JFileChooser.APPROVE_OPTION) {
            Properties properties = App.getSession().getProperties();
            Structure newStructure = App.getSession().getSceneControl()
                    .createNewStructure(properties.getStartPoint(), point);
            ((Picture) newStructure).setContentFromPath(fileLoader.getPath());
        }
    }
}
