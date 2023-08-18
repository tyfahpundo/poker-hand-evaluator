package com.tyfah.pockerhandevaluator.service.impl;

import com.tyfah.pockerhandevaluator.domain.Card;
import com.tyfah.pockerhandevaluator.domain.HandRank;
import com.tyfah.pockerhandevaluator.exception.InvalidRequestException;
import com.tyfah.pockerhandevaluator.service.PokerHandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PokerHandServiceImplTest {
    @Mock
    private PokerHandService pokerHandService;

    @InjectMocks
    private PokerHandServiceImpl pokerHandServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEvaluatePokerHand_TwoPair() {
        List<Card> hand = Arrays.asList(
                new Card("A", "Spades"),
                new Card("10", "Clubs"),
                new Card("10", "Hearts"),
                new Card("3", "Diamonds"),
                new Card("3", "Spades")
        );

        when(pokerHandService.evaluatePokerHand(hand))
                .thenReturn(HandRank.TWO_PAIR);

        HandRank result = pokerHandServiceImpl.evaluatePokerHand(hand);

        assertEquals(HandRank.TWO_PAIR, result);
    }

    @Test
    public void testEvaluatePokerHand_InvalidHandSize() {
        List<Card> invalidHand = Arrays.asList(
                new Card("A", "Spades"),
                new Card("10", "Clubs"),
                new Card("10", "Hearts")
        );

        assertThrows(InvalidRequestException.class,
                () -> pokerHandServiceImpl.evaluatePokerHand(invalidHand));
    }
}