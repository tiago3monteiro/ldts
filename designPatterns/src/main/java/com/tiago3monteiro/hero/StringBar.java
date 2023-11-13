package com.tiago3monteiro.hero;

import java.util.List;

public class StringBar extends Bar {
    private boolean isHappyHour = false;

    @Override
    public boolean isHappyHour() {
        return isHappyHour;
    }
    @Override
    public void startHappyHour() {isHappyHour = true; super.notifyObservers();}
    @Override
    public void endHappyHour()
    {
        isHappyHour = false;
        super.notifyObservers();
    }



}
