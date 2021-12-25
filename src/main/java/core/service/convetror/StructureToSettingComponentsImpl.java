package core.service.convetror;

import core.model.Structure;
import core.session.event.SettingFieldsListener;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StructureToSettingComponentsImpl implements StructureToSettingComponents {
    private final TextListener textListener = new SettingFieldsListener();

    @Override
    public List<JPanel> convert(Structure structure) {
        List<JPanel> components = new ArrayList<>();
        components.add(valuesToSettingComponent("type", structure.toString()));
        components.add(valuesToSettingComponent("x", (int) structure.getCenterPosition().getX()));
        components.add(valuesToSettingComponent("y", (int) structure.getCenterPosition().getY()));
        components.add(valuesToSettingComponent("stroke", (int) structure.getStroke()));
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
