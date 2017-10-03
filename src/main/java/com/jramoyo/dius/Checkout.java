package com.jramoyo.dius;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {
    private final PricingRules rules;
    private final Map<String, List<Item>> cart;

    public Checkout(PricingRules rules) {
        this.rules = rules;
        this.cart = new HashMap<>();
    }

    public void scan(Item item) {
        List<Item> items = cart.get(item.sku);
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);
    }

    public BigDecimal total() {
        return rules.total(new HashMap<>(cart));
    }

}