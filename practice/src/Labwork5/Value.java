package Labwork5;

public enum Value {
    two("2"),
    three("3"),
    four("4"),
    five("5"),
    six("6"),
    seven("7"),
    eight("8"),
    nine("9"),
    ten("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private  String title;

    Value(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
