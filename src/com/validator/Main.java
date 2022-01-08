package com.validator;

import com.rule.Min;
import com.rule.Required;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        //Validate depend on Map
        Map<String, Validator> validators = new HashMap<String, Validator>();
        Validator checkEmail = new StringValidator();
        checkEmail.addRule(new Min(10));
        checkEmail.addRule(new Required());
        validators.put("email", checkEmail);

        Validator checkAge = new NumericValidator();
        checkAge.addRule(new Min(18));
        validators.put("age", checkAge);



        Map<String, Object> form = new HashMap<String, Object>();
        form.put("email", "a@gmail.com");
        form.put("age", 17);

        ValidatorSchema schema1 = new ValidatorSchema();

        schema1.validate(form, validators);

        //******************************************************
        //******************************************************
        
        //Validate depend on object
        ValidatorSchema schema2 = new ValidatorSchema();
        Form form2 = new Form("a@gmail.com", 9);
        schema2.validate(form2);
    }
}
