package core.gui.dialog.file;

import core.App;
import core.lib.Service;
import javax.swing.JFileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class FileDialogImpl extends FileDialog {
    private static final Logger logger = LogManager.getLogger(FileDialogImpl.class);

    @Override
    public int openLoadDialogWindow() {
        wasOpened = true;
        logger.info("File load dialog was opened.");
        fileChooser.setDialogTitle("Choose file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        return fileChooser.showSaveDialog(App.getSession().getMainWindow());
    }

    @Override
    public int openSaveDialogWindow() {
        wasOpened = true;
        logger.info("File save dialog was opened.");
        fileChooser.setDialogTitle("Create file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        return fileChooser.showSaveDialog(App.getSession().getMainWindow());
    }
}
