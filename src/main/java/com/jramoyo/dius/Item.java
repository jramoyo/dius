package com.jramoyo.dius;

import java.math.BigDecimal;

public final class Item {
    public final String sku;
    public final String name;
    public final BigDecimal price;

    public Item(String sku, String name, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
}
