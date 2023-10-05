package com.tiago3monteiro.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private Screen screen;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;


    public Arena(int width, int height) {

        hero = new Hero(new Position(10, 10));
        this.width = width;
        this.height = height;
        this.screen = screen;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public void draw(Screen screen) throws IOException {

        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) wall.draw(graphics);
        for (Coin coin : coins) coin.draw(graphics);
        for (Monster monster : monsters) monster.draw(graphics);
        hero.draw(graphics);

    }

    public void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowRight -> moveHero(hero.moveRight());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case Character -> {
                if (key.getCharacter() == 'q') screen.close();
            }
        }
    }

    public void moveHero(Position position) throws IOException {
        if (canElementMove(position))
            hero.setPosition(position);
        moveMonsters();
        verifyMonsterCollisions();
        retrieveCoins();

    }

    private boolean canElementMove(Position position) {
        int x = position.getX();
        int y = position.getY();
        return (x > 0 && x < this.height - 1) && (y > 0 && y < this.width - 1);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }

    private void retrieveCoins() {
        for (Coin coin : coins) {
            if (coin.equals(hero.position)) {
                coins.remove(coin);
                System.out.println("Coin retrieved");
                break;
            }

        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return monsters;
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Random random = new Random();
            int nextMove = random.nextInt(1, 5);
            switch (nextMove) {
                case 1 -> {
                    if (canElementMove(monster.moveUp())) monster.setPosition(monster.moveUp());
                }
                case 2 -> {
                    if (canElementMove(monster.moveLeft())) monster.setPosition(monster.moveLeft());
                }
                case 3 -> {
                    if (canElementMove(monster.moveRight())) monster.setPosition(monster.moveRight());
                }
                case 4 -> {
                    if (canElementMove(monster.moveDown())) monster.setPosition(monster.moveDown());
                }

            }
        }

    }

    private void verifyMonsterCollisions() throws IOException {
        for (Monster monster : monsters) {
            if (monster.equals(hero.position)) {

                System.out.printf("Game over!");
                endGame();
                break;
            }
        }

    }

    public boolean endGame() {
        for (Monster monster : monsters) {
            if (monster.equals(hero.position)) return true;
            if (coins.isEmpty())
            {
                System.out.printf("g");
                return true;
            }
        }
        return false;
    }
}
