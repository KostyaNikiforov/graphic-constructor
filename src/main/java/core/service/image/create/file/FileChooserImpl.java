package core.service.image.create.file;

import core.App;
import core.Config;
import core.lib.Service;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class FileChooserImpl implements FileChooser {
    private static final Logger logger = LogManager.getLogger(FileChooserImpl.class);
    private final JFileChooser fileChooser = new JFileChooser();

    @Override
    public String openChooseWindow() {
        logger.info("File choosing...");
        fileChooser.setDialogTitle("Select file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(App.getSession().getMainWindow());
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();
            JOptionPane.showMessageDialog(null, "Image was saved by path: "
                    + filePath);
            return filePath;
        }
        JOptionPane.showMessageDialog(null, "Image was saved by default path: "
                + Config.DEFAULT_IMAGE_FILE_PATH);
        return Config.DEFAULT_IMAGE_FILE_PATH;
    }
}
