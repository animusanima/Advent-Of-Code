package de.animusanima.advent.of.code.days.two;

import de.animusanima.advent.of.code.utils.InputFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 03.12.2025 17:36
 */
public class DayTwo {

    public static void main(String[] args) {
        // Read input data from file
        List<String> data;
        try {
            String inputFileName = "src/main/resources/inputs/day_two.txt";
            data = InputFileReader.readDayTwoInputFromFileName(inputFileName);
        } catch (IOException e) {
            data = Collections.emptyList();
        }

        List<String> invalidIds = new ArrayList<>();
        for (String numbers : data) {
            String[] ids = numbers.split("-");

            System.out.println(Arrays.toString(ids));

            String idOne = ids[0];
            String idTwo = ids[1];
            System.out.println("ID One " + idOne);
            System.out.println("ID Two " + idTwo);
            for (int i = 0; i < idOne.length(); i += 2) {
                String partOne = i + 2 < idOne.length() ? idOne.substring(i, i + 2) : idOne.substring(i);
                String partTwo = i + 2 < idTwo.length() ? idTwo.substring(i, i + 2) : idTwo.substring(i);
                if (partOne.equals(partTwo)) {
                    invalidIds.add(partOne);
                }
            }
        }
        System.out.println(invalidIds);

    }

}
