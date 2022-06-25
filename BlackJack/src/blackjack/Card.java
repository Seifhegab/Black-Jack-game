package blackjack;


public class Card {
    public int suit;
    public int rank;
    public int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
    
    public Card(Card card){
       suit = card.suit;
       rank = card.rank;
       value = card.value;
    }

    
}
