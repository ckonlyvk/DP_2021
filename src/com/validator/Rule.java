package com.validator;

public abstract class Rule<T> {
    private Rule<T> next;

    Rule<T> getNext() {
        return next;
    }

    void setNext(Rule<T> rule) {
        next = rule;
    }

    String validateInteger(Integer value) {
        return "";
    }

    String validateString(String value) {
        return "";
    }

    String validate(Object value) {
        return switch (value.getClass().getSimpleName()) {
            case "String" -> validateString((String) value);
            case "Integer" -> validateInteger((Integer) value);
            default -> "";
        };
    }

}
