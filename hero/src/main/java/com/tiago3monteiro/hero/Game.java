package com.tiago3monteiro.hero;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        hero = new Hero(new Position(10,10));

    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
            while(true)
            {
                this.draw();
                KeyStroke key = screen.readInput();
                processKey(key);
                if(key.getKeyType() == KeyType.EOF) break;
            }

        }
    private void processKey(KeyStroke key) throws IOException
    {
        switch(key.getKeyType())
        {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowRight -> moveHero(hero.moveRight());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case Character -> { if(key.getCharacter() == 'q')  {screen.close();}}
        }
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    private Screen screen;
    private Hero hero;
}


