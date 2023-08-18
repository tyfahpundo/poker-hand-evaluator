package com.tyfah.pockerhandevaluator.controller;

import com.tyfah.pockerhandevaluator.domain.Card;
import com.tyfah.pockerhandevaluator.domain.HandRank;
import com.tyfah.pockerhandevaluator.service.PokerHandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PokerHandController {

    private final PokerHandService pokerHandService;

    @PostMapping("/evaluate-hand")
    public ResponseEntity<HandRank> evaluateHand(@RequestBody List<Card> hand) {
        HandRank handRank = pokerHandService.evaluatePokerHand(hand);
        return new ResponseEntity<>(handRank, HttpStatus.OK);
    }
}
