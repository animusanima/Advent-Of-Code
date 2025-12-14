package de.animusanima.advent.of.code.days.two.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InvalidIDFilterTest {

    InvalidIDFilter invalidIDFilter = new InvalidIDFilter("-");

    @Test
    void findInvalidIDsForEasyCase() {
        String id = "11-22";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).isEqualTo(Arrays.asList("11", "22"));
    }

    @Test
    void findInvalidIDsForToughCase() {
        String id = "1188511880-1188511890";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).isEqualTo(Arrays.asList("11885", "11885"));
    }

    @Test
    void hasDoubleDigitInID() {
        String id = "11-22";
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '1')).isTrue();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '2')).isTrue();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '3')).isFalse();
        assertions.assertAll();
    }

    @Test
    void hasDoubleDigitsInIDs() {
        String id = "1188511880-1188511890";
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '1')).isTrue();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '8')).isTrue();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '5')).isTrue();
        assertions.assertThat(invalidIDFilter.hasDoubleDigitInID(id, '9')).isFalse();
        assertions.assertAll();
    }

    @Test
    void extractDoubleDigits() {
    }
}