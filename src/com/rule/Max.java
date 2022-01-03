package com.rule;

public class Max extends Rule {
    int upperBound;

    public Max() {
        this.upperBound = 0;
    }

    public Max(int upperBound) {
        this.upperBound = upperBound;
    }

    public void setUperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public String validate(Double value) {
        String error = "";
        if(value.isNaN() ||value > upperBound) {
            error = "Do lon cua gia tri lon hon dieu kien";
        }

        return error;
    }

    @Override
    public String validate(String value) {
        String error = "";
        if(value.length()  > upperBound) {
            error = "Kich thuoc cua chuoi lon hon dieu kien";
        }

        return error;
    }
}
