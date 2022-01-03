package com.rule;

import java.util.regex.Pattern;

public class IsPhoneNumber extends CustomPattern {
    public IsPhoneNumber() {
        this.pattern = Pattern.compile("^\\d{10}$");
    }
}
