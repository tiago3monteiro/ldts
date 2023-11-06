package com.tiago3monteiro.hero;

import static java.lang.Character.*;

public class StringCaseChanger implements StringTransformer
{
    public StringCaseChanger() {}

    @Override
    public void execute(StringDrink drink)
    {
        String corrected = new String();
        String original = drink.getText();
        for(int i = 0; i < original.length();i++)
        {
            char current = original.charAt(i);
            if(isLowerCase(current))
            {
                corrected+= toUpperCase(current);

            }

            else corrected+= toLowerCase(current);

            drink.setText(corrected);
        }

    }
    public void undo(StringDrink drink)
    {
        String corrected = new String();
        String original = drink.getText();
        for(int i = 0; i < original.length();i++)
        {
            char current = original.charAt(i);
            if(isLowerCase(current))
            {
                corrected+= toUpperCase(current);

            }

            else corrected+= toLowerCase(current);

            drink.setText(corrected);
        }


    }


}
