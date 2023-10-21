package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {
    List<Integer> testList;

    @BeforeEach
    public void setTestLists() {
        testList = Arrays.asList(-2,-1, 0, 1);

    }

    @Test
    public void positiveFilterTest() {
        List<Integer> expected = Arrays.asList(1);
        PositiveFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> filtered = filterer.filter(testList);
        Assertions.assertEquals(expected, filtered);
    }


}