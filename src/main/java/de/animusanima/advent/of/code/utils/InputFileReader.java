package de.animusanima.advent.of.code.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 01.12.2025 17:43
 */
public abstract class InputFileReader {

    private InputFileReader() {
        // Hide implicit construction
    }

    public static List<String> readDayOneInputFromFileName(String fileName) throws IOException {
        List<String> inputData = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName))) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                inputData.add(line);
            }
        }
        return inputData;
    }

    public static List<String> readDayTwoInputFromFileName(String fileName) throws IOException {
        List<String> inputData = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName))) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] split = line.split(",");
                inputData.addAll(Arrays.asList(split));
            }
        }
        return inputData;
    }

}
