package com.rule;

public class Required extends Rule {

    @Override
    public String validate(String value) {
        String error = "";
        if(value.compareTo("") == 0) {
            error = "Gia tri rong";
        }

        return error;
    }

    @Override
    public String validate(Double value) {
        String error = "";
        if(value.isNaN()) {
            error = "Gia tri rong";
        }

        return error;
    }
}
