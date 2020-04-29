package hw2;

public class ArrayUtils {

    public long arraySum(Object[][] array) {
        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4)
            throw new ArraySizeException("Expected 4 by 4 array.");

        int resultSum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                Object object = array[i][j];
                String string = object + "";
                if (!string.matches("[0-9]+"))
                    throw new ArrayDataException("Expected array of strings containing numbers. " +
                            "Found \"not a number\" string: " + string + " (array[" + i + "][" + j + "])", i, j);
                resultSum += Integer.parseInt(string);
            }

        }

        return resultSum;
    }

}