package com.validator;

import java.util.Map;

public class ValidatorSchema {
    Map<String, Validator> validators;

    public ValidatorSchema(Map<String, Validator> validators) {
        this.validators = validators;
    }

    boolean validate(Map<String, Object> values) {
        for(String key : values.keySet()) {
            if(validators.containsKey(key)) {
                System.out.println("Validate " + key);
                validators.get(key).validate(values.get(key));
                System.out.println("-------------------------");
            }
        }

        return true;
    }
}
