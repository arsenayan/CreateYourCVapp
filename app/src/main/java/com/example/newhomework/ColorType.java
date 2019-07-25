package com.example.newhomework;

public enum ColorType {
    GRE("GREEN"),
    RED("RED"),
    YEL("YELLOW");

    private String type;
    ColorType(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }

    public static String toString(ColorType tsk)
    {
        return tsk.get();
    }
}
