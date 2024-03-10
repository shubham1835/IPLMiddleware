package com.ipl.middleware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GenerateOrderDTO {

    private String marketPlace;
    @NotNull(message = "orderId should not be null")
    @NotEmpty(message = "orderId should not be empty")
    private String orderId;
    @NotNull(message = "cartId should not be null")
    @NotEmpty(message = "cartId should not be empty")
    private String cartId;
    @NotNull(message = "totalCostPrice should not be null")
    @NotEmpty(message = "totalCostPrice should not be empty")
    private String totalCostPrice;
    @NotNull(message = "totalListPrice should not be null")
    @NotEmpty(message = "totalListPrice should not be empty")
    private String totalListPrice;
    @NotNull(message = "shipmentCharges should not be null")
    @NotEmpty(message = "shipmentCharges should not be empty")
    private String shipmentCharges;
    @NotNull(message = "marketPlaceTax should not be null")
    @NotEmpty(message = "marketPlaceTax should not be empty")
    private String marketPlaceTax;
    @NotNull(message = "commissionFees should not be null")
    @NotEmpty(message = "commissionFees should not be empty")
    private String commissionFees;
    @NotNull(message = "PackagingCost should not be null")
    @NotEmpty(message = "PackagingCost should not be empty")
    private String PackagingCost;
    @NotNull(message = "shippingDate should not be null")
    @NotEmpty(message = "shippingDate should not be empty")
    private String shippingDate;
    @NotNull(message = "OrderVariantDTOs should not be null")
    @NotEmpty(message = "OrderVariantDTOs should not be empty")
    private List<OrderVariantDTO> orderVariantDTOS;
    private String additionalInfo;
}
