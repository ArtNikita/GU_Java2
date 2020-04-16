package hw1;

public class Treadmill {
    private double length;
    private static int counter = 0;
    private int id;

    public Treadmill(double length) {
        this.length = length;
        id = counter++;
    }

    public double getLength() {
        return length;
    }

    public boolean take(Runnable runnable) {
        if(runnable.run(this)){
            System.out.println("Treadmill " + id + " passed!");
            return true;
        }
        System.out.println("Not enough strength..");
        System.out.println("Treadmill " + id + " is too long!!!");
        return false;
    }
}