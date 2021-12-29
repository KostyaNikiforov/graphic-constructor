package core.session.event;

import core.App;
import core.Config;
import core.controller.SettingController;
import core.controller.setting.HeightController;
import core.controller.setting.RadiusController;
import core.controller.setting.StrokeController;
import core.controller.setting.TextContentController;
import core.controller.setting.TextSizeContentController;
import core.controller.setting.WidthController;
import core.controller.setting.XController;
import core.controller.setting.YController;
import core.model.Structure;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.HashMap;
import java.util.Map;

public class SettingFieldsListener implements TextListener {
    private Map<String, SettingController> controllerMap;

    {
        controllerMap = new HashMap<>();
        controllerMap.put("Radius", new RadiusController());
        controllerMap.put("Height", new HeightController());
        controllerMap.put("Width", new WidthController());
        controllerMap.put("X", new XController());
        controllerMap.put("Y", new YController());
        controllerMap.put("Stroke", new StrokeController());
        controllerMap.put("Text", new TextContentController());
        controllerMap.put("Size", new TextSizeContentController());
        
    }

    @Override
    public void textValueChanged(TextEvent textEvent) {
        TextField textField = (TextField) textEvent.getSource();
        Structure structure = App.getSession().getProperties().getChosenStructure();
        String text = textField.getText();
        if (!text.equals("") && structure != null) {
           controllerMap.getOrDefault(textField.getName(), System.out::println).apply(text);
        }
        App.getSession().getSceneControl().update();
    }
}
