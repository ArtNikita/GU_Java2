package hw3;

import java.util.*;

public class StepicMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> directory = new TreeMap<>();
        while (in.hasNext()) {
            String[] input = in.nextLine().split(" ");
            String name = input[0] + " " + input[1];
            String product = input[2];
            Integer amount = Integer.valueOf(input[3]);
            if (!directory.containsKey(name)) {
                directory.put(name, new TreeMap<>());
            }
            if (!directory.get(name).containsKey(product)) {
                directory.get(name).put(product, 0);
            }
            directory.get(name).put(product, directory.get(name).get(product) + amount);
        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry : directory.entrySet()) {
            System.out.print(entry.getKey() + ": \n");
            for (Map.Entry<String, Integer> product : entry.getValue().entrySet()) {
                System.out.println("    " + product.getKey() + " " + product.getValue());
            }
        }
    }
}