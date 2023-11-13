package com.tiago3monteiro.hero;

public interface Client extends BarObserver
{
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
