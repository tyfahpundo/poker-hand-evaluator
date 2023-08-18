package com.tyfah.pockerhandevaluator.service;

import com.tyfah.pockerhandevaluator.domain.Card;
import com.tyfah.pockerhandevaluator.domain.HandRank;

import java.util.List;

public interface PokerHandService {
    HandRank evaluatePokerHand(List<Card> hand);
}
