package Labwork5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Deck {
    Card[] deck = new Card[52];
    Random rand = new Random();
    int index = 0;


    public Deck() {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        for (Value value : values) {
            for (Suit suit : suits) {
                deck[index] = new Card(suit, value);
                index++;
            }
        }
    }

    public Card takeCard() {
        Card card;
        card = deck[deck.length - 1];
        return card;
    }

    public Deck shuffle(){
        for (int i = deck.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            Card temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
        return this;
    }

    public void returnCard(Card card) {
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == card) {
                deck[i] = null;
                index = 0;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(deck);
    }
}
