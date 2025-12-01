package de.animusanima.advent.of.code.days.one.utils;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SafeCodeReaderTest {

    private final File testFile = new File("src/test/resources/day_one.txt");

    @Test
    void readCodeFromFileName() throws IOException {
        List<String> data = SafeCodeReader.readCodeFromFileName(testFile.getAbsolutePath());
        assertThat(data).isNotEmpty().hasSize(4484);
    }
}