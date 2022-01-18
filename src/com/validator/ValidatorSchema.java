package com.validator;

import com.notification.Notification;
import com.rule.Rule;
import com.rule.RuleFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidatorSchema {
	private Notification noti;
	
	ValidatorSchema(Notification notification)
	{
		this.noti = notification;
	}

    //Validate for map
    boolean validate(Map<String, Object> values,
                     Map<String, Validator> validators ) {
        List<ValidatorError> errors = new ArrayList<>();
        for(String key : values.keySet()) {
            if(validators.containsKey(key)) {
                String message = validators.get(key).validate(values.get(key));

                //Neu co loi thong bao
                if(!message.isEmpty()) {
                	ValidatorError temp = new ValidatorError(key, message);
                    errors.add(temp);
//                    System.out.println(new ValidatorError(key, message));
                    noti.notify("ERROR", temp.toString());
                }
            }
        }

        return true;
    }

    //Validate for specified object
    boolean validate(Object obj) throws IllegalAccessException {
        List<ValidatorError> errors = new ArrayList<>();

        //Duyet qua tung gia tri thuoc tinh cua doi tuong nhan vao
        for (Field field: obj.getClass().getDeclaredFields()) {
            Class type = field.getType(); //Lay kieu cua thuoc tinh day
            String name = field.getName(); //Lay ten cua thuoc tinh day

            //Dua vao type cua thuoc tinh khoi tao ra dung loai validator de su dung
            Validator validator = ValidatorFactory.getInstance().getValidator(type);

            //Duyet qua cac annotation cua thuoc tinh hien tai
            //Va them cac loai rule tuong ung voi annotation
            for(Annotation annotation : field.getDeclaredAnnotations()) {
                Rule rule = RuleFactory.getInstance().getRule(field, annotation);
                validator.addRule(rule);
            }

            String message = validator.validate(field.get(obj));

            //Neu co loi thong bao
            if(!message.isEmpty()) {
//                errors.add(new ValidatorError(name, message));
//                System.out.println(new ValidatorError(name, message));
            	ValidatorError temp = new ValidatorError(name, message);
                errors.add(temp);
//                System.out.println(new ValidatorError(key, message));
                noti.notify("ERROR", temp.toString());
            }

        }

        return true;
    }
}
