package com.validator;

import com.annotation.IsEmail;
import com.annotation.Max;
import com.annotation.Min;
import com.annotation.Required;

public class Form {
    @Min(lowerBound = 10)
    @Required
    @IsEmail
    String email;

    @Min(lowerBound = 10)
    @Max(upperBound = 20)
    @Required
    int age;

    public Form(String email, int age) {
        this.email = email;
        this.age = age;
    }
}
