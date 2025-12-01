package de.animusanima.advent.of.code.days.one;

import de.animusanima.advent.of.code.days.one.utils.SafeCodeReader;
import de.animusanima.advent.of.code.days.one.utils.SafeHelper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 01.12.2025 17:32
 */
public abstract class DayOne {
    private static int positionPartOne = 50;
    private static int positionPartTwo = 50;

    public static void main(String[] args) {
        // Read input data from file
        List<String> safeCodes;
        try {
            String inputFileName = "src/main/resources/inputs/day_one.txt";
            safeCodes = SafeCodeReader.readCodeFromFileName(inputFileName);
        } catch (IOException e) {
            safeCodes = Collections.emptyList();
        }

        /*
         * Read safe codes
         * Increate the solution number by one if the position hits 0 after rotating to the left
         */
        for (String code : safeCodes) {
            String rotationDirection = code.substring(0, 1);
            int rotationStep = Integer.parseInt(code.substring(1));
            positionPartOne = SafeHelper.findSolutionPartOne(positionPartOne, rotationDirection, rotationStep);
        }

        for (String code : safeCodes) {
            String rotationDirection = code.substring(0, 1);
            int rotationStep = Integer.parseInt(code.substring(1));
            positionPartTwo = SafeHelper.findSolutionPartTwo(positionPartTwo, rotationDirection, rotationStep);
        }

        // Print solution at the end to copy it into the web page of Advent of Code 2025, Day 1
        System.out.println("Solution Part One " + SafeHelper.getSolutionPartOne());
        System.out.println("Solution Part Two " + SafeHelper.getSolutionPartTwo());
    }

}
