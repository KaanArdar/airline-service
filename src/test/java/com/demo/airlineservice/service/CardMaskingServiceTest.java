package com.demo.airlineservice.service;

import com.demo.airlineservice.service.impl.CardMaskingService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


//TODO: add new test cases for edge cases
public class CardMaskingServiceTest {

    private CardMaskingService cardMaskingService;

    @Before
    public void setUp() {
        cardMaskingService = new CardMaskingService();
    }

    @Test
    public void should_mask_digits_for_basic_credit_cards() {
        //given
        String cardNumber = "4729150000000005";

        //when
        String maskedCardNumber = cardMaskingService.maskCardNumber(cardNumber);

        //then
        assertThat(maskedCardNumber).isEqualTo("472915******0005");
    }

    @Test
    public void should_mask_digits_for_credit_cards_in_different_format() {
        //given
        String cardNumber = "4729-1500-0000-0005";

        //when
        String maskedCardNumber = cardMaskingService.maskCardNumber(cardNumber);

        //then
        assertThat(maskedCardNumber).isEqualTo("4729-15**-****-0005");
    }

    @Test
    public void should_not_mask_anything_for_non_numeric_characters() {
        //given
        String cardNumber = "Kaan Ardar";

        //when
        String maskedCardNumber = cardMaskingService.maskCardNumber(cardNumber);

        //then
        assertThat(maskedCardNumber).isEqualTo("Kaan Ardar");
    }

    @Test
    public void should_not_mask_anything_for_non_card_size() {
        //given
        String cardNumber = "47291500000005";

        //when
        String maskedCardNumber = cardMaskingService.maskCardNumber(cardNumber);

        //then
        assertThat(maskedCardNumber).isEqualTo("47291500000005");
    }

    @Test
    public void should_mask_card_for_space_card_characters() {
        //given
        String cardNumber = "4729 -1500 -0000 -0005";

        //when
        String maskedCardNumber = cardMaskingService.maskCardNumber(cardNumber);

        //then
        assertThat(maskedCardNumber).isEqualTo("4729-15**-****-0005");
    }

}
