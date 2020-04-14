package OOD.Online_Shopping_System;

import java.util.Date;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public boolean sendNotification(Account account);
}
