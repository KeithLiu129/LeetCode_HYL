package OOD.Access_Control_System;

public class Badge {
    private final String badgeId;
    private String userId;

    public Badge(final String badgeId) {
        this.badgeId = badgeId;
    }

    public String getBadgeId() {
        return this.badgeId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
