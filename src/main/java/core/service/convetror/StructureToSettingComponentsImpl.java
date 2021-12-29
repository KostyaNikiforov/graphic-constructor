package core.service.convetror;

import core.model.Circle;
import core.model.Line;
import core.model.Rect;
import core.model.Structure;
import core.model.Text;
import core.session.event.SettingFieldsListener;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StructureToSettingComponentsImpl implements StructureToSettingComponents {
    private final TextListener textListener;

    public StructureToSettingComponentsImpl() {
        textListener = new SettingFieldsListener();
    }

    @Override
    public List<JPanel> convert(Structure structure) {
        List<JPanel> components = new ArrayList<>();
        String type = structure.getCreatingMode().toString();

        // TODO: Needs refactor
        components.add(valuesToSettingComponent("Type", type));
        components.add(valuesToSettingComponent("X", structure.getCenterPosition().x));
        components.add(valuesToSettingComponent("Y", structure.getCenterPosition().y));
        if (structure instanceof Rect) {
            Rect rect = (Rect) structure;
            components.add(valuesToSettingComponent("Stroke", structure.getStrokeWidth()));
            components.add(valuesToSettingComponent("Width", rect.getWidth()));
            components.add(valuesToSettingComponent("Height", rect.getHeight()));
        } else if (structure instanceof Circle) {
            Circle circle = (Circle) structure;
            components.add(valuesToSettingComponent("Stroke", structure.getStrokeWidth()));
            components.add(valuesToSettingComponent("Radius", circle.getRadius()));
        } else if (structure instanceof Text) {
            Text text = (Text) structure;
            components.add(valuesToSettingComponent("Text", text.getContent()));
            components.add(valuesToSettingComponent("Size", text.getSize()));
        } else if (structure instanceof Line) {
            components.add(valuesToSettingComponent("Stroke", structure.getStrokeWidth()));
        }
        return components;
    }

    private JPanel valuesToSettingComponent(String name, Object value) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel(name));
        TextField textField = new TextField(String.valueOf(value));
        textField.setName(name);
        textField.addTextListener(textListener);
        panel.add(textField);
        return panel;
    }
}
