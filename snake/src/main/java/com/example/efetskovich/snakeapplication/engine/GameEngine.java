package com.example.efetskovich.snakeapplication.engine;

import com.example.efetskovich.snakeapplication.enums.Direction;
import com.example.efetskovich.snakeapplication.enums.GameState;
import com.example.efetskovich.snakeapplication.enums.TileType;
import com.example.efetskovich.snakeapplication.models.Coordinate;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class GameEngine {

    public static final int GAME_WIDTH = 28;
    public static final int GAME_HEIGHT = 42;

    private List<Coordinate> walls;
    private List<Coordinate> snake;
    private List<Coordinate> apples;

    private Direction currentDirection = Direction.LEFT;
    private GameState currentGameState = GameState.RUNNING;

    private Random random;

    private boolean increaseTail = false;

    public GameEngine() {
        walls = new LinkedList<>();
        snake = new LinkedList<>();
        apples = new LinkedList<>();
        random = new Random();
    }

    public void initGame() {
        addWalls();
        addSnake();
        addApple();
    }

    public TileType[][] getMap() {
        TileType[][] map = new TileType[GAME_WIDTH][GAME_HEIGHT];

        // Total Field
        for (int x = 0; x < GAME_WIDTH; x++) {
            for (int y = 0; y < GAME_HEIGHT; y++) {
                map[x][y] = TileType.NOTHING;
            }
        }

        // Snake
        for (Coordinate sn : snake) {
            map[sn.getX()][sn.getY()] = TileType.SNAKE_TAIL;
        }
        map[snake.get(0).getX()][snake.get(0).getY()] = TileType.SNAKE_HEAD;

        // Walls
        for (Coordinate wall : walls) {
            map[wall.getX()][wall.getY()] = TileType.WALL;
        }

        // Apple
        for (Coordinate a : apples) {
            map[a.getX()][a.getY()] = TileType.APPLE;
        }

        return map;
    }

    public void update() {
        moveByDirection();
        checkWallCollision();
        checkSelfCollision();
        checkAppleCollision();
    }

    public void updateDirection(Direction newDirection) {
        if (Math.abs(newDirection.ordinal() - currentDirection.ordinal()) % 2 == 1) {
            currentDirection = newDirection;
        }
    }


    private void checkSelfCollision() {
        for (int i = 1; i < snake.size(); i++) {
            if (getSnakeHead().equals(snake.get(i))) {
                currentGameState = GameState.LOST;
                return;
            }
        }
    }

    private void checkAppleCollision() {
        Coordinate appleToRemove = null;
        for (Coordinate apple : apples) {
            if (getSnakeHead().equals(apple)) {
                appleToRemove = apple;
                increaseTail = true;
            }
        }

        if (appleToRemove != null) {
            apples.remove(appleToRemove);
            addApple();
        }

    }

    private void moveByDirection() {
        switch (currentDirection) {
            case DOWN:
                updateSnake(0, -1);
                break;
            case RIGHT:
                updateSnake(1, 0);
                break;
            case UP:
                updateSnake(0, 1);
                break;
            case LEFT:
                updateSnake(-1, 0);
                break;
        }
    }

    private void checkWallCollision() {
        for (Coordinate wall : walls) {
            if (snake.get(0).equals(wall)) {
                currentGameState = GameState.LOST;
            }
        }
    }

    private void addWalls() {
        // top and bottom
        for (int x = 0; x < GAME_WIDTH; x++) {
            walls.add(new Coordinate(x, 0));
            walls.add(new Coordinate(x, GAME_HEIGHT - 1));
        }

        // Left and right
        for (int y = 1; y < GAME_HEIGHT; y++) {
            walls.add(new Coordinate(0, y));
            walls.add(new Coordinate(GAME_WIDTH - 1, y));
        }
    }


    private void addSnake() {
        snake.clear();
        for (int x = 14; x < 20; x++) {
            snake.add(new Coordinate(x, GAME_HEIGHT / 2));
        }
    }

    private void addApple() {
        Coordinate coordinate = null;
        boolean added = false;

        while (!added) {
            int x = 1 + random.nextInt(GAME_WIDTH - 2);
            int y = 1 + random.nextInt(GAME_HEIGHT - 2);

            coordinate = new Coordinate(x, y);

            boolean collision = false;

            for (Coordinate s : snake) {
                if (s.equals(coordinate)) {
                    collision = true;
                    break;
                }
            }

            if (collision) {
                continue;
            }

            for (Coordinate a : apples) {
                if (a.equals(coordinate)) {
                    collision = true;
                    break;
                }
            }

            added = !collision;

        }

        apples.add(coordinate);

    }

    private void updateSnake(int x, int y) {

        int newX = snake.get(snake.size() - 1).getX();
        int newY = snake.get(snake.size() - 1).getY();

        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }

        if (increaseTail) {
            snake.add(new Coordinate(newX, newY));
            increaseTail = false;
        }

        snake.get(0).setX(snake.get(0).getX() + x);
        snake.get(0).setY(snake.get(0).getY() + y);

    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public Coordinate getSnakeHead() {
        return snake.get(0);
    }
}
