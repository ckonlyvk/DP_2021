package com.validator;

public class Required extends Rule{

    @Override
    String validateString(String value) {
        System.out.println("String required");
        return "required";
    }

    @Override
    String validateInteger(Integer value) {
        System.out.println("Integer required");
        return "required";
    }
}
