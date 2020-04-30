package hw5;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;
    private volatile static boolean atLeastOneThreadFinished = false;

    public static void main(String[] args) {
        longArrayRefactor(SIZE);
        shortArrayRefactor(SIZE);
    }

    private static void longArrayRefactor(int size) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        modifyArray(arr, 0);
        System.out.println((System.currentTimeMillis() - a) + " ms (simple modifying)\n");
    }

    private static void shortArrayRefactor(int size) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        int halfSize = size / 2;
        float[] a1 = new float[halfSize];
        float[] a2 = new float[halfSize];
        new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, halfSize);
            modifyArray(a1, 0);
            System.arraycopy(a1, 0, arr, 0, halfSize);
            afterThreadsComplete(a);
        }).start();
        new Thread(() -> {
            System.arraycopy(arr, halfSize, a2, 0, halfSize);
            modifyArray(a2, a2.length);
            System.arraycopy(a2, 0, arr, halfSize, halfSize);
            afterThreadsComplete(a);
        }).start();
    }

    private static void afterThreadsComplete(long a) {
        if (!Main.atLeastOneThreadFinished){
            Main.atLeastOneThreadFinished = true;
        } else {
            System.out.println((System.currentTimeMillis() - a) + " ms (two threads modifying)\n");
        }
    }

    private static void modifyArray(float[] array, int delta) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (i + delta) / 5.) * Math.cos(0.2f + (i + delta) / 5.) * Math.cos(0.4f + (i + delta) / 2.));
        }
    }
}
