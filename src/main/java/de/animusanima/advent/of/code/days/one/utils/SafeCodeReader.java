package de.animusanima.advent.of.code.days.one.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: David Sgro-Hinterseber <br>
 * Created by animusanima at 01.12.2025 17:43
 */
public abstract class SafeCodeReader {

    private SafeCodeReader() {
        // Hide implicit construction
    }

    public static List<String> readCodeFromFileName(String fileName) throws IOException {
        List<String> rotations = new ArrayList<>();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName))) {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                rotations.add(line);
            }
        }
        return rotations;
    }

}
