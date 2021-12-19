package core.model.type;

public enum StructureType {
    CIRCLE("Circle"),
    RECT("Rect"),
    LINE("Line");

    private String type;

    StructureType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
