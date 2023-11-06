package com.tiago3monteiro.hero;

import java.util.List;

public class StringRecipe  {
    public StringRecipe(List<StringTransformer> transformer)
    {
        this.transformer = transformer;

    }
    private List<StringTransformer> transformer;

    public void mix( StringDrink drink)
    {
        for(StringTransformer t: transformer)
        {
            t.execute(drink);
        }

    }
}
