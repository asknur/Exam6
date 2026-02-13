package Homework19.Task3;

public abstract class ChessFigure {
    private int coordinateX;
    private int coordinateY;
    private char figure;
    private String color;

    public ChessFigure(int coordinateX, int coordinateY, char figure, String color) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.figure = figure;
        this.color = color;
    }

    @Override
    public abstract String toString();

    public abstract void getCoordinates();

    public abstract void moveFigure(int x, int y);




    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public char getFigure() {
        return figure;
    }

    public void setFigure(char figure) {
        this.figure = figure;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
