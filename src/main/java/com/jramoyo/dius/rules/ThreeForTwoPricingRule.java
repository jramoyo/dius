package com.jramoyo.dius.rules;

import com.jramoyo.dius.Item;
import com.jramoyo.dius.PricingRule;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ThreeForTwoPricingRule implements PricingRule {

    @Override
    public BigDecimal total(String sku, Map<String, List<Item>> cart) {
        List<Item> items = cart.get(sku);
        if (items == null || items.isEmpty()) {
            return BigDecimal.ZERO;
        }

        int baseCount = items.size();
        int promoCount = ((baseCount / 3) * 2) + (baseCount % 3);

        return items.get(0).price.multiply(new BigDecimal(promoCount));
    }
}
