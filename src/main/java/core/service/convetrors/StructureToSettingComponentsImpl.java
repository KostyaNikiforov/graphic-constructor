package core.service.convetrors;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import core.model.Structure;
import core.session.handlers.SettingFieldsListener;

public class StructureToSettingComponentsImpl implements StructureToSettingComponents {
    private final TextListener textListener = new SettingFieldsListener();

    @Override
    public List<JPanel> convert(Structure structure) {
        List<JPanel> components = new ArrayList<>();
        components.add(valuesToSettingComponent("type", structure.toString()));
        for (Field field : structure.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                components.add(valuesToSettingComponent(field.getName(), field.getInt(structure)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot get asses to the field: "
                        + field.getName(), e);
            }
        }
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
