package de.animusanima.advent.of.code.days.two;

import de.animusanima.advent.of.code.utils.InputFileReader;

import java.io.IOException;
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

        data.stream().forEach(System.out::println);

    }

}
