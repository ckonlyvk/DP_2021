package com.rule;

import java.util.HashMap;
import java.util.Map;

;

public class RuleFactory {
    private static RuleFactory instance = null;
    private static Map<RuleType, Rule> rules = new HashMap<>();

    private RuleFactory() {
        initialize();
    }

    private void initialize() {
        rules.put(RuleType.MIN, new Min());
        rules.put(RuleType.MAX, new Max());
        rules.put(RuleType.REQUIRED, new Required());
        rules.put(RuleType.PATTERN, new CustomPattern());
        rules.put(RuleType.IS_EMAIL, new IsEmail());
        rules.put(RuleType.IS_PHONE_NUMBER, new IsPhoneNumber());
    }

    public static RuleFactory getInstance() {
        if(instance == null) {
            instance = new RuleFactory();
        }

        return instance;
    }

    public Rule getRule(RuleType type) {
        if(rules.containsKey(type)) {
            return rules.get(type);
        }

        return null;
    }
}
