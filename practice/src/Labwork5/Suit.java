package Labwork5;

public enum Suit {
    Hearts("♥"),
    Tiles("♦"),
    Cloves("♣"),
    Pikes("♠"),;

    private String title;

    Suit(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
