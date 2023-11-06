package com.tiago3monteiro.hero;

public class StringDrink {
    public StringDrink(String drink)
    {
        this.drink = drink;
    }
    public String getText()
    {
        return drink;
    }
    public void setText(String newDrink)
    {
        this.drink = newDrink;
    }

    private String drink;
}
