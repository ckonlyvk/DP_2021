package com.validator;

enum RuleType {
    MIN,
    MAX,
    REQUIRED
};

public class RuleFactory {
    private static RuleFactory instance = null;

    private RuleFactory() {}

    public static RuleFactory getInstance() {
        if(instance == null) {
            return new RuleFactory();
        }

        return instance;
    }

    static Rule getRule(RuleType type) {
        switch(type) {
            case MIN:
                return new Min(10);
            case REQUIRED:
                return new Required();
            default:
                return null;
        }
    }
}
