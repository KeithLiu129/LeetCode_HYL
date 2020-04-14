package OOD.Online_Shopping_System;

import java.util.Date;
import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;

    public boolean sendForShipment();
    public boolean makePayment(Payment payment);
    public boolean addOrderLog(OrderLog orderLog);
}
