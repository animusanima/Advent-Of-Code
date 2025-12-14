package de.animusanima.advent.of.code.days.two.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 14.12.2025 12:33
 */
public class InvalidIDFilter {

    private final String separator;

    public InvalidIDFilter(String separator) {
        this.separator = separator;
    }

    public List<String> findInvalidIDs(String input) {
        Set<String> invalidIDPartOne = new HashSet<>();
        Set<String> invalidIDPartTwo = new HashSet<>();
        Set<String> invalidIDBothParts = new HashSet<>();
        String[] ids = input.split(this.separator);

        for (Character c : ids[0].toCharArray()) {
            if (hasDoubleDigitInID(ids[0], c)) {
                invalidIDPartOne.add(extractDoubleDigits(ids[0], c));
            }
        }

        for (Character c : ids[1].toCharArray()) {
            if (hasDoubleDigitInID(ids[1], c)) {
                invalidIDPartTwo.add(extractDoubleDigits(ids[1], c));
            }
        }

        for (Character c : input.toCharArray()) {
            if (hasDoubleDigitsInIDs(ids[0], ids[1], c)) {
                String extractionIDOne = extractDoubleDigits(ids[0], c);
                String extractionIDTwo = extractDoubleDigits(ids[1], c);
                if (!extractionIDOne.isBlank() && !extractionIDTwo.isBlank()) {
                    invalidIDBothParts.add(extractionIDOne);
                    invalidIDBothParts.add(extractionIDTwo);
                }
            }
        }

        System.out.println(invalidIDPartOne);
        System.out.println(invalidIDPartTwo);
        System.out.println(invalidIDBothParts);

        StringBuilder combinedInvalidIDs = new StringBuilder();
        for (String invalidID : invalidIDBothParts) {
            combinedInvalidIDs.append(invalidID);
        }
        return new ArrayList<>(Collections.singleton(combinedInvalidIDs.toString()));
    }

    public boolean hasDoubleDigitInID(String id, Character digit) {
        int numberOfOccurences = 0;
        for (Character c : id.toCharArray()) {
            if (Character.isDigit(c) && !c.equals('0') && !String.valueOf(c).isEmpty() && c.equals(digit)) {
                numberOfOccurences++;
            }
            if (numberOfOccurences == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDoubleDigitsInIDs(String idOne, String idTwo, Character digit) {
        return hasDoubleDigitInID(idOne, digit) && hasDoubleDigitInID(idTwo, digit) || hasDigitInBothIDs(idOne, idTwo, digit);
    }

    public boolean hasDigitInBothIDs(String idOne, String idTwo, Character digit) {
        return idOne.indexOf(digit) == idTwo.indexOf(digit);
    }

    public String extractDoubleDigits(String id, Character digit) {
        StringBuilder result = new StringBuilder();
        int numberOfOccurences = 0;
        for (Character c : id.toCharArray()) {
            if (Character.isDigit(c) && !c.equals('0') && !String.valueOf(c).isEmpty() && c.equals(digit)) {
                numberOfOccurences++;
                result.append(c);
            }
            if (numberOfOccurences >= 2) {
                break;
            }
        }
        return result.toString();
    }

}
