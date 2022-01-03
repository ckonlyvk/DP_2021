package com.rule;

public class Min extends Rule {
    int lowerBound;

    public Min() {
        this.lowerBound = 0;
    }

    public Min(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    public String validate(Double value) {
        String error = "";
        if(value.isNaN() ||value < lowerBound) {
            error = "Do lon cua gia tri nho hon dieu kien";
        }

        return error;
    }

    @Override
    public String validate(String value) {
        String error = "";
        if(value.length()  < lowerBound) {
            error = "Kich thuoc cua chuoi nho hon dieu kien";
        }

        return error;
    }
}
