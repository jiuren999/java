package dome;

public class poker {

    private String suit;  //花色
    private int rank;  //数字

    public poker(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "{" + suit + '\'' +
                 rank + '\'' +
                '}';
    }
}
