package com.tiago3monteiro.hero;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.Objects;

public class Game {
    private Screen screen;
    private Arena arena;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        arena = new Arena(20,15);
        TextGraphics graphics = screen.newTextGraphics();
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
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
        if (Objects.requireNonNull(key.getKeyType()) == KeyType.Character) {
            if (key.getCharacter() == 'q') {
                screen.close();
            }
        } else {
            arena.processKey(key);
        }



    }
}


