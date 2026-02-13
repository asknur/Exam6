package Labwork5;

import java.util.Arrays;

public class Hand {
    private final Card[] cards = new Card[5];

    public void addCard(Card card){
        for (int i = 0; i < cards.length; i++) {
            if(cards[i] == null){
                cards[i] = card;
                break;
            }
        }
    }

    public Card replaceCard(int position, Card card){
        Card temp = cards[position];
        cards[position] = card;
        return temp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("").append(Arrays.toString(cards));
        return sb.toString();
    }
}
