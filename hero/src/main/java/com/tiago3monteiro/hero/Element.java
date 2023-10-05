package com.tiago3monteiro.hero;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    Position position;

    public Element(int x, int y) {
        this.position = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }
    public Position moveDown() { return new Position(position.getX(), position.getY() +1);}
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
    public Position moveRight() {
        return new Position(position.getX()+1, position.getY() );
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
    public boolean equals(Position position)
    {
        return (this.position.getX() == position.getX() && this.position.getY() == position.getY());

    }
}
