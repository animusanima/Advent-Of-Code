package de.animusanima.advent.of.code.days.two.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InvalidIDFilterTest {

    InvalidIDFilter invalidIDFilter = new InvalidIDFilter("-");

    @Test
    void findInvalidIDsForEasyCase() {
        String id = "11-22";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).isEqualTo(Arrays.asList("11", "22"));
    }

    @Test
    void indInvalidIDsForSecondEasyCase() {
        String id = "99-115";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).containsExactly("99");
    }

    @Test
    void findInvalidIDsForToughCase() {
        String id = "1188511880-1188511890";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).containsExactly("1188511885");
    }

    @Test
    void findInvalidIDsForSecondToughCase() {
        String id = "222220-222224";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).containsExactly("222222");
    }

    @Test
    void findInvalidIDsForThirdToughCase() {
        String id = "446443-446449";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).containsExactly("446446");
    }

    @Test
    void findInvalidIDsForFourthToughCase() {
        String id = "38593856-38593862";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).containsExactly("385938");
    }

    @Test
    void findInvalidIDsForValidIdReturnsEmptyList() {
        String id = "1698522-1698528";
        List<String> result = invalidIDFilter.findInvalidIDs(id);

        assertThat(result).isEmpty();
    }
}