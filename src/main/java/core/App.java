package core;

import core.lib.Injector;
import core.session.Session;

public class App {
    public static final Injector injector = Injector.getInstance("core.service");
    private static final Session session = new Session();

    public static void main(String[] args) {
        session.run();
    }

    public static Session getSession() {
        return session;
    }
}
