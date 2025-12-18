package de.animusanima.advent.of.code.days.two.utils;

import java.util.ArrayList;
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
        Set<String> invalidIds = new HashSet<>();
        String[] ids = input.split(this.separator);

        // ID parts have the same length
        if ((ids[0].length() % 2 == 0) && (ids[1].length() % 2 == 0)) {
            String idOnePartOne = ids[0].substring(0, ids[0].length() / 2);
            String idOnePartTwo = ids[0].substring(ids[0].length() / 2);
            String idTwoPartOne = ids[1].substring(0, ids[1].length() / 2);
            String idTwoPartTwo = ids[1].substring(ids[1].length() / 2);

            if (idOnePartOne.equals(idOnePartTwo)) {
                invalidIds.add(idOnePartOne + idOnePartTwo);
            }
            if (idTwoPartOne.equals(idTwoPartTwo)) {
                invalidIds.add(idTwoPartOne + idTwoPartTwo);
            }
            if (idOnePartOne.equals(idTwoPartOne)) {
                invalidIds.add(idOnePartOne + idTwoPartOne);
            }
            if (idOnePartTwo.equals(idTwoPartTwo)) {
                invalidIds.add(idOnePartTwo + idTwoPartTwo);
            }
        } else if (ids[0].length() % 2 == 0) {
            String idPartOne = ids[0].substring(0, ids[0].length() / 2);
            String idPartTwo = ids[0].substring(ids[0].length() / 2);

            if (idPartOne.equals(idPartTwo)) {
                invalidIds.add(idPartOne + idPartTwo);
            }
        } else if (ids[1].length() % 2 == 0) {
            String idPartOne = ids[1].substring(0, ids[1].length() / 2);
            String idPartTwo = ids[1].substring(ids[1].length() / 2);

            if (idPartOne.equals(idPartTwo)) {
                invalidIds.add(idPartOne + idPartTwo);
            }
        }
        return new ArrayList<>(invalidIds);
    }

    public String splitStringInHalve(String source) {
        if (source == null) {
            return "";
        }
        return source.substring(0, source.length() / 2);
    }

}
