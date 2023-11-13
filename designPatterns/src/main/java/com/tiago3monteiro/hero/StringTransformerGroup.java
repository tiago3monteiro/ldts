package com.tiago3monteiro.hero;

import java.util.List;

public class StringTransformerGroup implements StringTransformer
{
    public StringTransformerGroup(List<StringTransformer> steps)
    {
        this.steps = steps;
    }

    private List<StringTransformer> steps;

    @Override
    public void execute(StringDrink drink)
    {
        for(StringTransformer step: steps)
        {
            step.execute(drink);
        }
    }

    @Override
    public void undo(StringDrink drink)
    {
        for(StringTransformer step: steps)
        {
            step.undo(drink);
        }

    }
}
