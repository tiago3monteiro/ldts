package com.tiago3monteiro.hero;

public class StringInverter implements StringTransformer {
    public StringInverter() {

    }

    @Override
    public void execute(StringDrink drink) {
        String inverted = new String();
        String notInverted = drink.getText();
        for(int i = notInverted.length()-1; i >=0; i--)
        {
            inverted += notInverted.charAt(i);
            
        }
        drink.setText(inverted);

    }

    @Override
    public void undo(StringDrink drink) {
        String inverted = new String();
        String notInverted = drink.getText();
        for(int i = notInverted.length()-1; i >=0; i--)
        {
            inverted += notInverted.charAt(i);

        }
        drink.setText(inverted);

    }

}
