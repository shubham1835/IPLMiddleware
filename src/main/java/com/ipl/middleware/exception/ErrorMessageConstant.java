package com.ipl.middleware.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessageConstant {
    STORE_NOT_EXIST("store not exist", 353, HttpStatus.NOT_FOUND),
    PRODUCT_EXIST("product already exist", 352, HttpStatus.CONFLICT),
    PRODUCT_NOT_EXIST("product not exist", 359, HttpStatus.NOT_FOUND),
    CATEGORY_NOT_EXIST("product category not exist", 351, HttpStatus.NOT_FOUND),
    VARIANT_NOT_EXIST("product variant not exist", 360, HttpStatus.NOT_FOUND),
    VARIANT_VALUE_NOT_EXIST("product variant value not exist", 361, HttpStatus.NOT_FOUND),
    CATEGORY_EXIST("product category already exist", 350, HttpStatus.CONFLICT),
    INVALID_USER("Invalid user", 401, HttpStatus.UNAUTHORIZED),
    INVALID_REQUEST("Bad Request", 400, HttpStatus.BAD_REQUEST),
    REGISTERED_USER("User is already registered", 354, HttpStatus.CONFLICT),
    FOLDER_NOT_CREATED("Some Error Occurred while uploading file", 356, HttpStatus.INTERNAL_SERVER_ERROR),
    UPLOAD_DOCUMENT("Please upload document", 357, HttpStatus.UNAUTHORIZED),
    INVALID_OTP("Please provide valid OTP", 358, HttpStatus.UNAUTHORIZED),
    ORDER_EXIST("Order Exist", 362, HttpStatus.CONFLICT),
    BID_EXIST("Bid Exist", 700, HttpStatus.CONFLICT),
    MATCH_NOT_EXIST("Match Not Exist", 701, HttpStatus.NOT_FOUND),
    BID_TIME_OVER("Bidding time is over", 703, HttpStatus.NOT_ACCEPTABLE),
    INVALID_BID("Bid Amount Should be greater than 30", 702, HttpStatus.BAD_REQUEST),
    USER_NOT_EXIST("User Not Found", 404, HttpStatus.NOT_FOUND);

    private String message;
    private int statusCode;
    private HttpStatus status;
}
