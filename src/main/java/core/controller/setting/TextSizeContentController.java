package core.controller.setting;

import core.App;
import core.controller.SettingController;
import core.model.Structure;
import core.model.Text;

public class TextSizeContentController implements SettingController {
    @Override
    public void apply(String text) {
        Structure structure = App.getSession().getProperties().getChosenStructure();
        if (text.matches("\\d+")) {
            ((Text) structure).setSize(Integer.parseInt(text));
        } else {
            throw new RuntimeException("Unsupported symbol in the text size field.");
        }
    }
}
