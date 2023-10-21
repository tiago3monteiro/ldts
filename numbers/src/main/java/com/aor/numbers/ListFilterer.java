package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;


public class ListFilterer {

    private final GenericListFilter filter;
    public ListFilterer(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list){

        List<Integer> res = new ArrayList<>();
        for (Integer num : list) {
            if (filter.accept(num)) {
                res.add(num);
            }
        }
        return res;
    }


}