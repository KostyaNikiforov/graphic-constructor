package core.gui.models.menu.items;

public class MenuItem extends Item {
    private SubMenuItem[] elements;

    public MenuItem(String name, SubMenuItem[] elements) {
        super(name);
        this.elements = elements;
    }

    public SubMenuItem[] getElements() {
        return elements;
    }
}
