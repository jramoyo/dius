package com.jramoyo.dius;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricingRules {
    private final Map<String, PricingRule> rules;

    public PricingRules(Map<String, PricingRule> rules) {
        this.rules = new HashMap<>(rules);
    }

    public BigDecimal total(Map<String, List<Item>> cart) {

        return cart.entrySet().stream().map((entry) -> {

            String sku = entry.getKey();
            PricingRule rule = rules.get(sku);
            if (rule == null) {
                List<Item> items = entry.getValue();
                return sum(items);
            } else {
                return rule.total(sku, cart);
            }

        }).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private BigDecimal sum(List<Item> items) {
        return items.stream().map(i -> i.price).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
