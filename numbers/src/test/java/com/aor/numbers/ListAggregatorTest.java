package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> list;

    @BeforeEach
    public void setup() {
        list = Arrays.asList(1, 2, 4, 2, 5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(Arrays.asList(-1, -4, -5));
        Assertions.assertEquals(-1, max);
    }

    public Integer max(List<Integer> list) {
        // int max = 0;
        int max = Integer.MIN_VALUE;
        for (Integer number : list)
            if (number > max)
                max = number;
        return max;
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);
    }
    @Test
    public void max_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(3, distinct);
    }
}
