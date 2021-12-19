package core;

import core.session.Session;

public class App {
    private static final Session session = new Session();

    public static void main(String[] args) {
        session.run();
    }

    public static Session getSession() {
        return session;
    }
}
