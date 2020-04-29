package hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //1 задача
        System.out.println("First task");
        String[] wordsArray = {"D", "A", "B", "A", "C", "B", "C", "C", "A", "A"};
        //Используем HashSet, если необходимо вывести только уникальные значения
        HashSet<String> wordsSet = new HashSet<>(Arrays.asList(wordsArray));
        System.out.println(wordsSet);

        //Если, помимо уникальных значений, требуется найти их количество
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word : wordsArray) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordsMap);

        //2 задача
        System.out.println("\nSecond task");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Artamonov", "+79117777777");
        phonebook.add("Dyakov", "+79111111111");
        phonebook.add("Artamonov", "+79119999999");
        System.out.println(phonebook.get("Artamonov"));
        System.out.println(phonebook.get("Dyakov"));
        System.out.println(phonebook.get("Sherstneva"));
    }
}
