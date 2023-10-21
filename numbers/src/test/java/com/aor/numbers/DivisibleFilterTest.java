package com.aor.numbers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleFilterTest {
    List<Integer> testList1;
    List<Integer> testList2;

    @BeforeEach
    public void setTestLists() {
        testList1 = Arrays.asList(1,2,3,4,5,6);
        testList2 = Arrays.asList(1,2,3,5,10,16,54,5, 18);
    }

    @Test
    public void filterTest1() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> filtered = filterer.filter(testList1);
        List<Integer> expected = Arrays.asList(2,4,6);

        Assertions.assertEquals(expected, filtered);

    }

    @Test
    public void filterTest2() {
        DivisibleByFilter filter = new DivisibleByFilter(3);
        ListFilterer filterer = new ListFilterer(filter);

        List<Integer> filtered = filterer.filter(testList2);
        List<Integer> expected = Arrays.asList(3, 54, 18);

        Assertions.assertEquals(expected, filtered);

    }

}
