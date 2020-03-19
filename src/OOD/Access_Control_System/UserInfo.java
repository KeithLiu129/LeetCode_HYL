package OOD.Access_Control_System;


import java.util.Date;

public class UserInfo {
    //must-have
    private final String userId;
    private int level;
    private Position position;

    //Nice-to-have
    private String username;
    private String email;
    private int tenure;
    private String orgId;

    public String getUserId() {
        return userId;
    }

    public int getLevel() {
        return level;
    }

    public Position getPosition() {
        return position;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getTenure() {
        return tenure;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getCurrentBadgeId() {
        return currentBadgeId;
    }

    //for Lost && Found
    private String currentBadgeId;

    private UserInfo(final Builder builder) {
        userId = builder.userId;
        position = builder.position;
        level = builder.level;
        tenure = builder.tenure;
        orgId = builder.orgId;
        currentBadgeId = builder.currentBadgeId;
    }

    public static class Builder {
        //must-have
        private final String userId;
        private int level;
        private Position position;

        //Nice-to-have
        private String username;
        private String email;
        private int tenure;
        private String orgId;

        //for Lost && Found
        private String currentBadgeId;



        public Builder(final String userId) {
            this.userId = userId;
            level = 0;
            tenure = 0;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setSecurityLevel(final int level) {
            this.level = level;
            return this;
        }

        public Builder setBadgeId(final String badgeId) {
            this.currentBadgeId = badgeId;
            return this;
        }

        public Builder setOrgId(final String org) {
            this.orgId = org;
            return this;
        }

        public Builder setTenure(final int tenure) {
            this.tenure = tenure;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
