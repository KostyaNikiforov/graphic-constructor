package core.service.scene.history;

public interface History<T> {
    void add(T data);

    T next();

    T last();

    T current();

    int getSize();

    boolean clear();
}
