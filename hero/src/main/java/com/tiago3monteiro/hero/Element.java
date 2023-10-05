package com.tiago3monteiro.hero;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    Position position;

    public Element(int x, int y) {
        this.position = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);
    public void setPosition(Position position)
    {
        this.position = position;
    }
    public boolean equals(Position position)
    {
        return (this.position.getX() == position.getX() && this.position.getY() == position.getY());

    }
}
