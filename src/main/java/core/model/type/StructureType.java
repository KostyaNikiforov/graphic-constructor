package core.model.type;

import core.session.enums.CreatingMode;

public enum StructureType {
    CIRCLE("Circle", CreatingMode.CIRCLE),
    RECT("Rect", CreatingMode.RECT),
    LINE("Line", CreatingMode.LINE),
    TEXT("Text", CreatingMode.TEXT);

    private String type;
    private CreatingMode creatingMode;

    StructureType(String type, CreatingMode creatingMode) {
        this.type = type;
        this.creatingMode = creatingMode;
    }

    public CreatingMode getCreatingMode() {
        return creatingMode;
    }

    @Override
    public String toString() {
        return type;
    }
}
