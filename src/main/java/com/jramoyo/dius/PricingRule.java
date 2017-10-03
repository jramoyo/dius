package com.jramoyo.dius;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PricingRule {
    BigDecimal total(String sku, Map<String, List<Item>> cart);
}
