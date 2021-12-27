package core.session.enums;

public enum CreatingMode {
    MOVING("Moving"),
    HIGHLIGHTING("Highlighting"),
    IMAGE_EXTRACT("Image extracting"),
    CIRCLE("Circle"),
    LINE("Line"),
    RECT("Rect"),
    TEXT("Text"),
    LAYER("Layer"),
    PICTURE("Picture");

    private final String type;

    CreatingMode(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
