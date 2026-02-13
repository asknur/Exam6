package Homework19.Task3;

public class Task3 {
    public static void main(String[] args) {
        King king = new King(1,1, 'k', "White");
        king.getCoordinates();
        System.out.println(king);
        king.moveFigure(5,7);
        king.getCoordinates();
    }
}
