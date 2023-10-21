package com.aor.numbers;

import java.util.List;

public class DivisibleByFilter implements GenericListFilter{
    private final Integer base;
    public DivisibleByFilter(Integer base) {
        this.base = base;
    }
    @Override
    public boolean accept(Integer number) {
        return (number % base == 0);
    }
}