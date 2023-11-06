package com.tiago3monteiro.hero;

import static java.lang.Character.*;

public class StringReplacer implements StringTransformer{
    public StringReplacer(char oldChar, char newChar)
    {
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    private char oldChar;
    private char newChar;

    @Override
    public void execute(StringDrink drink)
    {
        String original = drink.getText();
        String corrected = new String();
        for(int i = 0; i < original.length();i++)
        {
            char current = original.charAt(i);
            if(current == oldChar)
            {
                corrected+= newChar;

            }
            else corrected += current;

            drink.setText(corrected);
        }

    }

    @Override
    public void undo(StringDrink drink)
    {
        String original = drink.getText();
        String corrected = new String();
        for(int i = 0; i < original.length();i++)
        {
            char current = original.charAt(i);
            if(current == newChar)
            {
                corrected+= oldChar;

            }
            else corrected += current;

            drink.setText(corrected);
        }

    }
}
