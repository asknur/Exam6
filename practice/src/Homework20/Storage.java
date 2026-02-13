package Homework20;

public enum Storage {
    Icebox("Icebox"),
    Showcase("Showcase");

    private String title;

    Storage(String title) {
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
