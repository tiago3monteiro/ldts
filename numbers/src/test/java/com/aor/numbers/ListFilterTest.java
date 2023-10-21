package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    List<Integer> testList1;

    @BeforeEach
    public void setTestLists() {
        testList1 = Arrays.asList(1,2,3); //{1,2,3}
    }
    @Test
    public void filtererTest1() {
        List<Integer> expected = Arrays.asList(1,2,3);
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        ListFilterer filterer = new ListFilterer(filter);

        Mockito.when(filter.accept(Mockito.any(Integer.class))).thenReturn(true);
        List<Integer> filtered = filterer.filter(testList1);

        Assertions.assertEquals(expected, filtered);
    }

}
