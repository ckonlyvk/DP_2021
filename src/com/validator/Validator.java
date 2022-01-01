package com.validator;

public class Validator {
    Rule head;
    Rule pointer;

//    void addRule(RuleType type) {
//        Rule rule = RuleFactory.getInstance().getRule(type);
//        if(head == null) {
//            head = rule;
//            pointer = head;
//        }
//        else {
//            this.pointer.setNext(rule);
//            this.pointer = rule;
//        }
//    }

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
            temp.validate( value);
            temp = temp.getNext();
        }
    }
}
