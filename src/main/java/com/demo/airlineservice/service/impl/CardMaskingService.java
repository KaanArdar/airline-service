package com.demo.airlineservice.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CardMaskingService {

    final Pattern PATTERN = Pattern.compile("^([0-9]{15,16})+$");

    public String maskCardNumber(String cardNumber) {
        String strippedCreditCard = cardNumber.replaceAll("[ -]+", "");

        if (isCardNumberValid(strippedCreditCard)) {

            if (cardNumber.contains("-")) {
                return maskCardNumbersWithHyphens(strippedCreditCard).toString();
            } else {
                return maskCardForNumbers(strippedCreditCard).toString();
            }

        } else {
            return cardNumber;
        }
    }

    private boolean isCardNumberValid(String strippedCreditCard) {
        Matcher regexMatcher = PATTERN.matcher(strippedCreditCard);
        return regexMatcher.find();
    }

    private StringBuilder maskCardForNumbers(String cardNumber) {
        String subSectionOfCreditCard = cardNumber.substring(6, cardNumber.length() - 4);
        StringBuilder builder = new StringBuilder();
        builder.append(cardNumber, 0, 6);
        builder.append(String.join("", Collections.nCopies(subSectionOfCreditCard.length(), "*")));
        builder.append(cardNumber.substring(cardNumber.length() - 4));
        return builder;
    }

    private StringBuilder maskCardNumbersWithHyphens(String cardNumber) {
        StringBuilder builder = maskCardForNumbers(cardNumber);
        builder.insert(4, "-");
        builder.insert(9, "-");
        builder.insert(14, "-");
        return builder;
    }
}