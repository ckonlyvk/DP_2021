package com.validator;

import com.notification.ConsoleNotification;
import com.notification.Notification;
import com.notification.WindowNotification;
import com.rule.Min;
import com.rule.Required;
import com.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
//        Rule rule = new Rule() {
//            @Override
//            public String validate(Double value) {
//                if(value %2 != 0) return "So khong chia het cho 2";
//                return "";
//            }
//
//            @Override
//            public String validate(String value) {
//                return "DMM";
//            }
//        };
//
//        //Validate depend on Map
        Map<String, Validator> validators = new HashMap<String, Validator>();
        Validator checkEmail = new StringValidator();
        checkEmail.addRule(new Min(10));
        checkEmail.addRule(new Required());
        validators.put("email", checkEmail);
//
//
        Validator checkAge = new NumericValidator();
        checkAge.addRule(new Min(19));
        validators.put("age", checkAge);
//
//
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("email", "a@gmail.com");
        form.put("age", 17);
        
        
        Notification notiWindow = new WindowNotification();
        Notification notiConsole = new ConsoleNotification();
        ValidatorSchema schema1 = new ValidatorSchema(notiWindow);

        schema1.validate(form, validators);

        //******************************************************
        //******************************************************
        
        //Validate depend on object

        ValidatorSchema schema2 = new ValidatorSchema(notiWindow);
        Student student = new Student(
           "NguyenVanA",
           "a@gmail.com",
           "0986059068",
           20,
           12
        );
        schema2.validate(student);

        
    }
}
