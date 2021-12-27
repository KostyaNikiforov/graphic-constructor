package core.gui.dialog.file;

import javax.swing.JFileChooser;

public abstract class FileDialog implements FileLoader, FileSaver {
    protected JFileChooser fileChooser = new JFileChooser();
    protected boolean wasOpened = false;

    @Override
    public String getPath() {
        if (wasOpened) {
            return fileChooser.getSelectedFile().getPath();
        }
        throw new RuntimeException("Can't get file path before opening dialog window.");
    }
}
