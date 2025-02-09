package com.personalprojects.clients.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConvertion {

    public BigDecimal convert(String input) {

        if (input == null || input.length() == 0) {
            return null;
        }

        input = input.replace(".", "").replace(",", ".");
        return new BigDecimal(input);
    }
}
