package com.example.efetskovich.snakeapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.efetskovich.snakeapplication.engine.GameEngine;
import com.example.efetskovich.snakeapplication.enums.Direction;
import com.example.efetskovich.snakeapplication.enums.GameState;
import com.example.efetskovich.snakeapplication.views.SnakeView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button startGameButton;
    private GameEngine gameEngine;
    private SnakeView snakeView;
    private final Handler handler = new Handler();
    private final long updateDelay = 200;

    private float prevX;
    private float prevY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGame();
    }

    private void initGame() {
        initInstances();
    }

    private void initInstances() {
        gameEngine = new GameEngine();
        gameEngine.initGame();
        gameEngine.setCurrentGameState(GameState.READY);
        snakeView = (SnakeView) findViewById(R.id.snakeGame);
        snakeView.setOnTouchListener(this);
        startGameButton = (Button) findViewById(R.id.startGame);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameEngine.setCurrentGameState(GameState.RUNNING);
                startGameButton.setVisibility(View.GONE);
                startUpdateHandler();
            }
        });
    }


    private void startUpdateHandler() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameEngine.update();

                checkOnGameRunning(this);
                checkOnGameLost();


                snakeView.setSnakeViewMap(gameEngine.getMap());
                snakeView.invalidate();
            }
        }, updateDelay);
    }

    private void checkOnGameRunning(Runnable runnable) {
        if (gameEngine.getCurrentGameState() == GameState.RUNNING) {
            handler.postDelayed(runnable, updateDelay);
        }
    }

    private void checkOnGameLost() {
        if (gameEngine.getCurrentGameState() == GameState.LOST) {
            gameLost();
        }
    }

    private void gameLost() {
        Toast.makeText(MainActivity.this, "You lost", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = motionEvent.getX();
                prevY = motionEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                float newX = motionEvent.getX();
                float newY = motionEvent.getY();

                // Calculate where we swiped
                if (Math.abs(newX - prevX) > Math.abs(newY - prevY)) {
                    leftRightDirection(newX, prevX);
                } else {
                    upDownDirection(newY, prevY);
                }

                break;
        }
        return true;
    }

    private void leftRightDirection(float newX, float prevX) {
        if (newX > prevX) {
            gameEngine.updateDirection(Direction.RIGHT);
        } else {
            gameEngine.updateDirection(Direction.LEFT);
        }
    }

    private void upDownDirection(float newY, float prevY) {
        if (newY > prevY) {
            gameEngine.updateDirection(Direction.UP);
        } else {
            gameEngine.updateDirection(Direction.DOWN);
        }
    }

}
