package com.ipl.middleware.modal;

import lombok.Data;
import org.javers.core.metamodel.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("order_master")
public class GenerateOrderModal {
    @Id
    private String id;
    private String orderId;
    private String marketPlace;
    private String cartId;
    private String totalCostPrice;
    private String totalListPrice;
    private String shipmentCharges;
    private String marketPlaceTax;
    private String commissionFees;
    private String PackagingCost;
    private String shippingDate;
    private List<OrderVariantModal> orderVariantDTOS;
    private String additionalInfo;
}
