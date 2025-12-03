package de.animusanima.advent.of.code.days.one.utils;

import de.animusanima.advent.of.code.utils.InputFileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputFileReaderTest {

    private final File testFile = new File("src/test/resources/day_one.txt");

    @Test
    void readDayOneInputFromFileName() throws IOException {
        List<String> data = InputFileReader.readDayOneInputFromFileName(testFile.getAbsolutePath());
        assertThat(data).isNotEmpty().hasSize(4484);
    }
}