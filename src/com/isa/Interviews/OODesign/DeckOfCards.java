package com.isa.Interviews.OODesign;

import java.util.ArrayList;

/**
 * Created by isa on 2017-04-02.
 */
public class DeckOfCards<T extends Card> {

    /*
        Design the data structures for a generic deck of cards.
        Explain how you would subclass the data structures to implement blackjack.
     */

    private ArrayList<T> cards;

    private int dealtIndex = 0; // marks first undealt card

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    // helper functions
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = randomIntInRange(i, cards.size() - i - 1);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }

        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }

        return hand;
    }

    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }

        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;

        return card;
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}

// all class below should be made public
// currently put them this way so that one file is needed

class BlackJackCard extends Card{
    public BlackJackCard(int c, Suit s) {
        super(c, s);
    }

    public int value() {
        if (isAce()) { // Ace
            return 1;
        } else if (faceValue >= 11 && faceValue <= 13) { // Face card
            return 10;
        } else { // Number card
            return faceValue;
        }
    }

    public int minValue() {
        if (isAce()) { // Ace
            return 1;
        } else {
            return value();
        }
    }

    public int maxValue() {
        if (isAce()) { // Ace
            return 11;
        } else {
            return value();
        }
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
}

class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScores() {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        if (cards.size() == 0) {
            return scores;
        }
        for (BlackJackCard card : cards) {
            addCardToScoreList(card, scores);
        }
        return scores;
    }

    private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            scores.add(0);
        }
        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.minValue());
            if (card.minValue() != card.maxValue()) {
                scores.add(score + card.maxValue());
            }
        }
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        BlackJackCard first = cards.get(0);
        BlackJackCard second = cards.get(1);
        return (first.isAce() && second.isFaceCard()) || (second.isAce() && first.isFaceCard());
    }
}

class Hand<T extends Card>{
    protected ArrayList<T> cards = new ArrayList<T>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}

abstract class Card{
    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    /* returns whether or not the card is available to be given out to someone */
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }

    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case Club:
                System.out.print("c");
                break;
            case Heart:
                System.out.print("h");
                break;
            case Diamond:
                System.out.print("d");
                break;
            case Spade:
                System.out.print("s");
                break;
        }
        System.out.print(" ");
    }
}

// public should be declared inits own class
enum Suit{
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private int value;
    private Suit(int v) {
        value = v;
    }

    public int getValue(){
        return value;
    }

    // can have both static and non-static methods in a class, depending on use cases
    public static Suit getSuitFromValue(int value){
        switch (value){
            case 0:
                return Club;
            case 1:
                return Diamond;
            case 2:
                return Heart;
            case 3:
                return Spade;
            default:
                return null;
        }
    }
}