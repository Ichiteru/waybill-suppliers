package com.itechart.students_lab.waybill_suppliers.entity;

public enum Permission {
    CUSTOMERS_WRITE("customers:write"),
    CUSTOMERS_READ("customers:read"),
    CATEGORIES_READ("categories:read"),
    CATEGORIES_WRITE("categories:write"),
    ITEMS_WRITE("items:write"),
    ITEMS_READ("items:read"),
    WAREHOUSE_ITEMS_WRITE("warehouseItems:write"),
    WAREHOUSE_ITEMS_READ("warehouseItems:read"),
    EMPLOYEES_READ("employees:read"),
    EMPLOYEES_WRITE("employees:write"),
    WAREHOUSES_WRITE("warehouses:write"),
    WAREHOUSES_READ("warehouses:read"),
    CARS_WRITE("cars:write"),
    CARS_READ("cars:read"),
    DISPATCHING_APPLICATIONS_READ("applications.dispatching:read"),
    DISPATCHING_APPLICATIONS_WRITE("applications.dispatching:write"),
    ALL_APPLICATIONS_READ("applications.all:read"),
    ALL_APPLICATIONS_WRITE("applications.all:write"),
    ACCOUNT_READ("account:read"),
    ACCOUNT_WRITE("account:write"),
    WRITE_OFF_READ_ALL("writeOff:read"),
    WRITE_OFF_READ_BY_WAREHOUSE("warehouseWriteOff:read"),
    WRITE_OFF_READ_BY_DRIVER("driverWriteOff:read"),
    WRITE_OFF_WRITE("writeOff:write"),
    ALL_WAYBILLS_READ("waybills:read"),
    ALL_WAYBILLS_WRITE("waybills:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
