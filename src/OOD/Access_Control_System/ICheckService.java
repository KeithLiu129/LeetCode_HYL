package OOD.Access_Control_System;


import java.util.List;

public interface ICheckService {
      int getUserLevel(final String userId);

      int getCheckerLevel(final String checkerId);

      String getUserBadgeId(final String userId);

      List<ICheckRule> getCheckRules(final String checkerId);

      UserInfo getUserInfo(final String userId);

    //mutiple rules to open the door

}
