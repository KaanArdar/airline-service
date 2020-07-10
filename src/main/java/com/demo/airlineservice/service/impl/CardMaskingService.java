package com.demo.airlineservice.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CardMaskingService {

    private final Pattern PATTERN = Pattern.compile("^([0-9]{15,16})+$");
    private final String SEPARATION = "-";
    private final String STAR = "*";
    private final int NUMBER_ZERO = 0;
    private final int NUMBER_SIX = 6;
    private final int NUMBER_FOUR = 4;

    public String maskCardNumber(String cardNumber) {
        String strippedCreditCard = cardNumber.replaceAll("[ -]+", "");

        if (isCardNumberValid(strippedCreditCard)) {

            if (cardNumber.contains(SEPARATION)) {
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
        String subSectionOfCreditCard = cardNumber.substring(NUMBER_SIX, cardNumber.length() - NUMBER_FOUR);
        StringBuilder builder = new StringBuilder();
        builder.append(cardNumber, NUMBER_ZERO, NUMBER_SIX);
        builder.append(String.join("", Collections.nCopies(subSectionOfCreditCard.length(), STAR)));
        builder.append(cardNumber.substring(cardNumber.length() - NUMBER_FOUR));
        return builder;
    }

    private StringBuilder maskCardNumbersWithHyphens(String cardNumber) {
        StringBuilder builder = maskCardForNumbers(cardNumber);
        builder.insert(4, SEPARATION);
        builder.insert(9, SEPARATION);
        builder.insert(14, SEPARATION);
        return builder;
    }
}