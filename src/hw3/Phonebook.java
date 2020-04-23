package hw3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> phonebook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (!phonebook.containsKey(surname)) {
            phonebook.put(surname, new ArrayList<>());
        }
        phonebook.get(surname).add(phoneNumber);
    }

    public ArrayList<String> get(String surname) {
        return phonebook.get(surname);
    }
}
