package com.itechart.students_lab.waybill_suppliers.entity;

public enum Permission {
    CUSTOMERS_WRITE("customers:write"),
    CUSTOMERS_READ("customers:read"),
    ITEMS_WRITE("items:write"),
    ITEMS_READ("items:read"),
    WAREHOUSE_ITEMS_WRITE("warehouseItems:write"),
    WAREHOUSE_ITEMS_READ("warehouseItems:read"),
    WAREHOUSES_WRITE("warehouses:write"),
    WAREHOUSES_READ("warehouses:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
