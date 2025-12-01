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
    private static int position = 50;

    public static void main(String[] args) {
        int password = 0;
        List<String> safeCodes;
        try {
            String inputFileName = "src/main/resources/inputs/day_one.txt";
            safeCodes = SafeCodeReader.readCodeFromFileName(inputFileName);
        } catch (IOException e) {
            safeCodes = Collections.emptyList();
        }

        // Read Rotation from List
        // Parse letter and number to decide which way to rotate
        // Starting Point is 50
        /*
            You could follow the instructions, but your recent required official North Pole secret entrance security training
            seminar taught you that the safe is actually a decoy. The actual password is the number of times the dial
            is left pointing at 0 after any rotation in the sequence.
         */
        for (String code : safeCodes) {
            String rotationDirection = code.substring(0, 1);
            int rotationStep = Integer.parseInt(code.substring(1));
            position = SafeHelper.findSolution(position, rotationDirection, rotationStep);
        }

        System.out.println("Solution found " + SafeHelper.getSolution());
    }

}
