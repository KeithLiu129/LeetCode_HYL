package OOD.Access_Control_System;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    private final String checkerId;
    private int level;
    private final ICheckService checkService;
    private List<ICheckRule> rules;

    public Checker(final String checkerId, final ICheckService service) {
        this.checkerId = checkerId;
        this.level = level;
        checkService = service;
        rules = new ArrayList<>();
        updateCheckerSetting();
    }

    private void updateCheckerSetting(){
        this.level = checkService.getCheckerLevel(checkerId);
        this.rules = checkService.getCheckRules(checkerId);
    }

    public boolean isValid(@NotNull final String userId) {
        int userLevel = checkService.getUserLevel(userId);
        return userLevel >= this.level;
    }

    public boolean checkWithMultipleRule(@NotNull final String userId, @NotNull final String badgeId) {
        final UserInfo userInfo = checkService.getUserInfo(userId);
        for (ICheckRule rule : rules) {
            if (!rule.isValid()) {
                return false;
            }
        }
        return checkValid(userId, badgeId);
    }

    public boolean checkValid(@NotNull final String userId, @NotNull final String badgeId) {
        final String curId = checkService.getUserBadgeId(userId);
        return badgeId.equals(curId);
    }
}
