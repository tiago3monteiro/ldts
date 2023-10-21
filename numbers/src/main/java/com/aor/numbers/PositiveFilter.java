package com.aor.numbers;

import java.util.List;

public class PositiveFilter implements GenericListFilter {

    @Override
    public boolean accept(Integer number) {
        return (number > 0);
    }
}
