package Homework22.Task2;

public class Parallelepiped {
    private int length;
    private int width;
    private int height;

    public Parallelepiped(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getTotalArea(){
        int p = 2 * ((length * width) + (width * height) + (length * height));
        return p;
    }
}
