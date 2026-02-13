package Labwork5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Card[] cards = new Card[5];
    Scanner sc = new Scanner(System.in);


    Deck deck = new Deck();
    public void start() {
        cards[0] = new Card(Suit.Hearts, Value.eight);
        cards[1] = new Card(Suit.Cloves, Value.five);
        cards[2] = new Card(Suit.Tiles, Value.KING);
        cards[3] = new Card(Suit.Pikes, Value.JACK);

        System.out.println(deck.shuffle());

        System.out.printf("%s  %s  %s  %s %s\n",
                cards[0].toString(),
                cards[1].toString(),
                cards[2].toString(),
                cards[3].toString(),
                cards[4] = deck.takeCard());

        deck.takeCard();

        Hand hand = new Hand();
        hand.addCard(cards[0]);
        hand.addCard(cards[1]);
        hand.addCard(cards[2]);
        hand.addCard(cards[3]);
        hand.addCard(cards[4]);
        System.out.println("Введите номера карт, которые вы хотите заменить через пробел: ");
        int cardPosition = sc.nextInt();
        if (cardPosition < 1 || cardPosition > 5) {
            System.out.println("Позиция карты не должна превышать 5");
        } else {
            hand.replaceCard(cardPosition, new Card(Suit.Hearts, Value.ACE));
            System.out.println(hand.toString());
        }

    }

}
