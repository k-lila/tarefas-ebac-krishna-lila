package main.dao.generics;

import java.util.LinkedHashMap;

public class Singleton {
    private static Singleton singleton;
    protected LinkedHashMap<Class, LinkedHashMap<?, ?>> datasingle;

    private Singleton() {
        this.datasingle = new LinkedHashMap<>();
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public LinkedHashMap<Class, LinkedHashMap<?, ?>> getSingle() {
        return this.datasingle;
    }
}
