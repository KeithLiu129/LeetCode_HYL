package OOD.Access_Control_System;

public enum Position {
    CEO("CEO", 3),
    TEACHER("TEACHER", 2),
    STUDENT("STUDENT", 1);

    final String type;
    final int level;

    Position(final String type, final int level) {
        this.type = type;
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
}
