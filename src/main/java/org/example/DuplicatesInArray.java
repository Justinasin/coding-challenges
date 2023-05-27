package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInArray {

    public static void removeDuplicatesFromArray(List<String> listOfStrings) {
        if (listOfStrings.size() <= 1) {
            System.out.println("List size is too short to look for duplicates");
            return;
        }

        Set<String> setOfStrings = new HashSet<>();
        for (String str : listOfStrings) {
            setOfStrings.add(str);
        }

        listOfStrings.clear();
        listOfStrings.addAll(setOfStrings);
    }
}
