package hw1;

public class Cat implements Runnable, Jumpable {

    private double runLengthRestriction;
    private double jumpHeight;
    private int jumpAmountRestriction;
    private static int counter = 0;
    private int id;

    public Cat(double runLengthRestriction, double jumpHeight, int jumpAmountRestriction) {
        this.runLengthRestriction = runLengthRestriction;
        this.jumpHeight = jumpHeight;
        this.jumpAmountRestriction = jumpAmountRestriction;
        id = counter++;
    }

    @Override
    public boolean jump(Wall wall) {
        if (jumpAmountRestriction <= 0) return false;
        System.out.println("Cat " + id + " jumped.");
        jumpAmountRestriction--;
        return !(wall.getHeight() > jumpHeight);
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (runLengthRestriction <= 0) return false;
        System.out.println("Cat " + id + " started running.");
        runLengthRestriction -= treadmill.getLength();
        return runLengthRestriction >= 0;
    }
}