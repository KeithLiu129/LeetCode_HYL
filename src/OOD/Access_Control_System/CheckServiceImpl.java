package OOD.Access_Control_System;

import java.util.List;

public class CheckServiceImpl implements ICheckService {

    @Override
    public int getUserLevel(String userId) {
        return 0;
    }

    @Override
    public int getCheckerLevel(String checkerId) {
        return 0;
    }

    @Override
    public String getUserBadgeId(String userId) {
        return null;
    }

    @Override
    public List<ICheckRule> getCheckRules(String checkerId) {
        return null;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return null;
    }
}
