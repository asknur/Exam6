package Homework19.Task3;

public class Queen extends ChessFigure {
    public Queen(int coordinateX, int coordinateY, char figure, String color) {
        super(coordinateX, coordinateY, 'Q', color);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChessFigure{");
        sb.append("coordinateX=").append(getCoordinateX());
        sb.append(", coordinateY=").append(getCoordinateY());
        sb.append(", figure=").append(getFigure());
        sb.append(", color=").append(getColor());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void getCoordinates() {
        System.out.printf("Coordinate x -> %d and coordinate y -> %d%n", getCoordinateX(), getCoordinateY());
    }

    @Override
    public void moveFigure(int x, int y) {
        setCoordinateX(x);
        setCoordinateY(y);
    }
}
