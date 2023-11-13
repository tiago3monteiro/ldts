package com.tiago3monteiro.hero;

public class HumanClient implements Client
{
    HumanClient() {}

    @Override
    public void happyHourStarted(Bar bar)
    {
        bar.startHappyHour();
    }

    @Override
    public void happyHourEnded(Bar bar)
    {
        bar.endHappyHour();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {

    }
}
