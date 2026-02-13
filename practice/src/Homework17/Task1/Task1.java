package Homework17.Task1;

public class Task1 {
    public static void main(String[] args) {

        Television tv = new Television(7, 7);
        System.out.println(tv.getChannelNameByNumber());
        tv.getPreviousChannel();
        System.out.println(tv.getChannelNameByNumber());
        tv.getPreviousChannel();
        tv.getPreviousChannel();
        System.out.println(tv.getChannelNameByNumber());
        tv.getNextChannel();
        System.out.println(tv.getChannelNameByNumber());


    }

    
}
