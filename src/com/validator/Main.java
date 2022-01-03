package com.validator;

import com.rule.Min;
import com.rule.Required;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, Validator> validators = new HashMap<String, Validator>();
        Validator checkEmail = new StringValidator();
        checkEmail.addRule(new Min(10));
        checkEmail.addRule(new Required());
        validators.put("email", checkEmail);

        Validator checkAge = new NumericValidator();
        checkAge.addRule(new Min(18));
        validators.put("age", checkAge);

        ValidatorSchema schema = new ValidatorSchema(validators);

        Map<String, Object> form = new HashMap<String, Object>();
        form.put("email", null);
        form.put("age", null);

        schema.validate(form);

    }
}
