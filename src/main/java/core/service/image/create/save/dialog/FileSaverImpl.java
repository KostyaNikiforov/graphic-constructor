package core.service.image.create.save.dialog;

import core.App;
import core.lib.Service;
import javax.swing.JFileChooser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class FileSaverImpl implements FileSaver {
    private static final Logger logger = LogManager.getLogger(FileSaverImpl.class);
    private final JFileChooser fileChooser = new JFileChooser();
    private boolean wasOpened;

    @Override
    public int openSaveDialogWindow() {
        wasOpened = true;
        logger.info("File save dialog was opened.");
        fileChooser.setDialogTitle("Create file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        return fileChooser.showSaveDialog(App.getSession().getMainWindow());
    }

    @Override
    public String getPath() {
        if (wasOpened) {
            return fileChooser.getSelectedFile().getPath();
        }
        throw new RuntimeException("Can't get file path before opening dialog window.");
    }
}
