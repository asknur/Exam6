package Homework14;

public class Task1 {

    public static void main(String[] args){
        getMaxNumber(4,8,2);
        getMaxNumber(4.7f, 4.1f, 4.9f);

    }

    static int getMaxNumber(int a, int b, int c){
        int number = 0;
        if(a > b && a > c){
            number = a;
            System.out.println("The max number is " + a);
        } else if(b > a && b > c){
            number = b;
            System.out.println("The max number is " + b);
        } else if(c > a && c > b){
            number = c;
            System.out.println("The max number is " + c);
        }
        return number;
    }

    static float getMaxNumber(float a, float b, float c){
        float number = 0;
        if(a > b && a > c){
            number = a;
            System.out.println("The max number is " + a);
        }  else if(b > a && b > c){
            number = b;
            System.out.println("The max number is " + b);
        }  else if(c > a && c > b){
            number = c;
            System.out.println("The max number is " + c);
        }
        return number;
    }
}
