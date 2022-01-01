package com.validator;

public class Min<T> extends Rule<T> {
    int lowerBound;

    Min(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    @Override
    String validateInteger(Integer value) {
        if(value>lowerBound) {
            System.out.println("Do lon cua value thoa dieu kien");
        }
        else {
            System.out.println("Do lon cua value khong lon hon " + Integer.toString(lowerBound));
        }
        return "min";
    }

    @Override
    String validateString(String value) {
        if(value.length() >lowerBound) {
            System.out.println("Kich thuoc cua value thoa dieu kien");
        }
        else {
            System.out.println("Kich thuoc cua value khong du " + Integer.toString(lowerBound) + "ky tu");
        }
        return "min";
    }
}
