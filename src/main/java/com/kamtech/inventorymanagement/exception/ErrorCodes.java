package com.kamtech.inventorymanagement.exception;

public enum ErrorCodes {

    CATEGORY_NOT_FOUND(1000),
    CATEGORY_NOT_VALID(1001),
    CUSTOMER_NOT_FOUND(2000),
    CUSTOMER_ORDER_NOT_FOUND(3000),
    CUSTOMER_ORDER_NOT_VALID(3001),
    CUSTOMER_ORDER_LINE_NOT_FOUND(4000),
    ENTERPRISE_NOT_FOUND(5000),
    ENTERPRISE_NOT_VALID(5001),
    ITEM_NOT_FOUND(6000),
    ITEM_NOT_VALID(6001),
    ROLES_NOT_FOUND(7000),
    SALES_NOT_FOUND(8000),
    SALES_LINE_NOT_FOUND(9000),
    STK_MVT_NOT_FOUND(10000),
    SUPPLIER_NOT_FOUND(11000),
    SUPPLIER_NOT_VALID(11001),
    SUPPLIER_ORDER_NOT_FOUND(12000),
    SUPPLIER_ORDER_LINE_NOT_FOUND(13000),
    USER_NOT_FOUND(14000),
    USER_NOT_VALID(14001),
    ;

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

}
