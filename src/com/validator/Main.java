package com.validator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Validator> validators = new HashMap<String, Validator>();
        Validator checkEmail = new Validator();
        checkEmail.addRule(new Min(10));
        checkEmail.addRule(new Required());
        validators.put("email", checkEmail);

        Validator checkAge = new Validator();
        checkAge.addRule(new Min(18));
        validators.put("age", checkAge);

        ValidatorSchema schema = new ValidatorSchema(validators);

        Map<String, Object> form = new HashMap<String, Object>();
        form.put("email", "a@gmail.com");
        form.put("age", 18);

        schema.validate(form);
        
//        Object obj = 10;
//        System.out.println(obj.getClass());
    }
}
