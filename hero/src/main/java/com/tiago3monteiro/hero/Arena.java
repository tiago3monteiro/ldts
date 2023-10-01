package com.tiago3monteiro.hero;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private Screen screen;

    public Arena(int width, int height)
    {
        hero = new Hero(new Position(10,10));
        this.width = width;
        this.height = height;
    }

    public void draw(Screen screen) throws IOException {
        hero.draw(screen);
    }

    public void processKey(KeyStroke key) throws IOException {
        switch(key.getKeyType())
        {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowRight -> moveHero(hero.moveRight());
            case ArrowLeft -> moveHero(hero.moveLeft());
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    private boolean canHeroMove(Position position) {
        int x = position.getX();
        int y = position.getY();
        return (x >= 0 && x < this.height) && (y >= 0 && y < this.width);
    }



}
