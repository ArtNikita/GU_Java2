package hw1;

public class Wall {
    private double height;
    private static int counter = 0;
    private int id;

    public double getHeight() {
        return height;
    }

    public Wall(double height) {
        this.height = height;
        id = counter++;
    }

    public boolean take(Jumpable jumpable) {
        if (jumpable.jump(this)){
            System.out.println("Wall " + id + " passed!");
            return true;
        }
        System.out.println("Not enough strength..");
        System.out.println("Wall " + id + " is too high!!!");
        return false;
    }
}