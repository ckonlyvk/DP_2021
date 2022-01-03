package com.validator;

import com.rule.Rule;
import com.rule.RuleFactory;
import com.rule.RuleType;

public abstract class Validator {
    Rule head;
    Rule pointer;

    void addRule(RuleType type) {
        RuleFactory ruleFactory = RuleFactory.getInstance();
        Rule rule = ruleFactory.getRule(type);
        if(head == null) {
            head = rule;
            pointer = head;
        }
        else {
            this.pointer.setNext(rule);
            this.pointer = rule;
        }
    }

    void addRule(Rule rule) {
        if(head == null) {
            head = rule;
            pointer = head;
        }
        else {
            this.pointer.setNext(rule);
            this.pointer = rule;
        }
    }


    void validate(Object value) {
        Rule temp = head;

        while (temp!=null) {
            String error = excuteValidate(temp, value);
            temp = temp.getNext();
        }
    }

    abstract String excuteValidate(Rule rule, Object value);
}
