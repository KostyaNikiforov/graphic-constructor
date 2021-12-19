package core.session.handlers;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import core.App;
import core.Config;
import core.model.Structure;

public class SettingFieldsListener implements TextListener {
    @Override
    public void textValueChanged(TextEvent textEvent) {
        TextField textField = (TextField) textEvent.getSource();
        Structure structure = App.getSession().getProperties().getChosenStructure();
        String text = textField.getText();
        if (!text.equals("") && structure != null && text.matches("\\d+")) {
            Config.STRUCTURE_SETTING_CONTROLLER_MAP
                    .getOrDefault(textField.getName(), System.out::println).apply(text);
        }
        // System.out.println("Field name: " + textField + "; Value: " + text);
        App.getSession().getSceneControl().update();
    }
}
