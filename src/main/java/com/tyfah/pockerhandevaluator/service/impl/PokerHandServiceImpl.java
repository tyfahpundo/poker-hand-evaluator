package com.tyfah.pockerhandevaluator.service.impl;

import com.tyfah.pockerhandevaluator.domain.Card;
import com.tyfah.pockerhandevaluator.domain.HandRank;
import com.tyfah.pockerhandevaluator.exception.InvalidRequestException;
import com.tyfah.pockerhandevaluator.service.PokerHandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PokerHandServiceImpl implements PokerHandService {

    public HandRank evaluatePokerHand(List<Card> hand) {
        if (hand.size() != 5) {
            throw new InvalidRequestException("A poker hand must have exactly 5 cards.");
        }

        Map<String, Integer> rankCounts = new HashMap<>();
        Map<String, Integer> suitCounts = new HashMap<>();

        for (Card card : hand) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
            suitCounts.put(card.getSuit(), suitCounts.getOrDefault(card.getSuit(), 0) + 1);
        }

        boolean hasStraight = false;
        boolean hasFlush = false;
        boolean hasThreeOfAKind = false;
        boolean hasFourOfAKind = false;
        boolean hasPair = false;
        boolean hasTwoPair = false;

        for (int count : rankCounts.values()) {
            if (count == 2) {
                if (hasPair) {
                    hasTwoPair = true;
                }
                hasPair = true;
            } else if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 4) {
                hasFourOfAKind = true;
            }
        }

        if (suitCounts.size() == 1) {
            hasFlush = true;
        }

        List<String> ranks = new ArrayList<>(rankCounts.keySet());
        Collections.sort(ranks, Collections.reverseOrder());

        if (ranks.size() == 5) {
            int diff = ranks.get(0).charAt(0) - ranks.get(4).charAt(0);
            if (diff == 4 || (diff == 12 && ranks.get(0).charAt(0) == 'A')) {
                hasStraight = true;
            }
        }

        if (hasStraight && hasFlush) {
            if (ranks.get(0).charAt(0) == 'A' && ranks.get(4).charAt(0) == 'K') {
                return HandRank.ROYAL_FLUSH;
            }
            return HandRank.STRAIGHT_FLUSH;
        }
        if (hasFourOfAKind) {
            return HandRank.FOUR_OF_A_KIND;
        }
        if (hasThreeOfAKind && hasPair) {
            return HandRank.FULL_HOUSE;
        }
        if (hasFlush) {
            return HandRank.FLUSH;
        }
        if (hasStraight) {
            return HandRank.STRAIGHT;
        }
        if (hasThreeOfAKind) {
            return HandRank.THREE_OF_A_KIND;
        }
        if (hasTwoPair) {
            return HandRank.TWO_PAIR;
        }
        if (hasPair) {
            return HandRank.ONE_PAIR;
        }
        return HandRank.HIGH_CARD;
    }
}
