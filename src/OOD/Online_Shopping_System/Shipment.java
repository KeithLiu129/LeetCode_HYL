package OOD.Online_Shopping_System;

import java.util.Date;
import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedArrival;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogs;

    public boolean addShipmentLog(ShipmentLog shipmentLog);
}