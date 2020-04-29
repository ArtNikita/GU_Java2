package hw2;

public class Main {
    public static void main(String[] args) {
        Object[][] array = new Object[][]{
                {'b', "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", '3', "4"},
                {"1", "2", "3", "a"}};
        while (true) {
            try {
                long result = new ArrayUtils().arraySum(array);
                System.out.println("Result: " + result);
                break;
            } catch (ArraySizeException ase) {
                ase.printStackTrace();
                System.out.println("Change input array (size).");
                break;
            } catch (ArrayDataException ade) {
                System.out.println(ade.getMessage());
                System.out.println("Element [" + ade.getI() + "][" + ade.getJ() + "] was changed to 0 value.");
                array[ade.getI()][ade.getJ()] = 0;
            }
        }

        System.out.println("\nOther operations....");
    }
}
