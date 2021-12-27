package core.service.processe;

import core.App;
import core.Config;
import core.gui.dialog.file.FileDialogImpl;
import core.gui.dialog.file.FileSaver;
import core.service.image.create.ImageCreator;
import java.awt.Point;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImageExtracting implements ProcessHandler {
    private final ImageCreator imageCreator
            = (ImageCreator) App.injector.getInstance(ImageCreator.class);
    private final FileSaver fileSaver = new FileDialogImpl();

    @Override
    public void finish(Point point) {
        int result = fileSaver.openSaveDialogWindow();
        switch (result) {
            case JFileChooser.APPROVE_OPTION:
                String filePath = fileSaver.getPath();
                JOptionPane.showMessageDialog(null, "Image was saved by path: "
                        + filePath);
                imageCreator.create(App.getSession().getProperties()
                        .getStartPoint(), point, filePath);
                break;
            case JFileChooser.CANCEL_OPTION:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Image was saved by default path: "
                        + Config.DEFAULT_IMAGE_FILE_PATH);
                imageCreator.create(App.getSession().getProperties()
                        .getStartPoint(), point, Config.DEFAULT_IMAGE_FILE_PATH);
        }
    }
}
