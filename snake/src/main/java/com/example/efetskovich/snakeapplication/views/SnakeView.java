package com.example.efetskovich.snakeapplication.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.efetskovich.snakeapplication.enums.TileType;

/**
 * @author e.fetskovich on 11/9/17.
 */

public class SnakeView extends View{

    private Paint paint = new Paint();
    private TileType snakeViewMap[][];

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap(TileType[][] snakeViewMap) {
        this.snakeViewMap = snakeViewMap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (snakeViewMap != null) {
            float tileSizeX = canvas.getWidth() / snakeViewMap.length;
            float tileSizeY = canvas.getHeight() / snakeViewMap[0].length;

            float circleSize = Math.min(tileSizeX, tileSizeY) / 2;

            for (int x = 0; x < snakeViewMap.length; x++) {
                for (int y = 0; y < snakeViewMap[x].length; y++) {
                    switchTileType(snakeViewMap[x][y]);

                    canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, paint);

                }
            }


        }
    }

    private void switchTileType(TileType tileType) {
        switch (tileType) {
            case NOTHING:
                paint.setColor(Color.WHITE);
                break;
            case WALL:
                paint.setColor(Color.GREEN);
                break;
            case SNAKE_HEAD:
                paint.setColor(Color.RED);
                break;
            case SNAKE_TAIL:
                paint.setColor(Color.GRAY);
                break;
            case APPLE:
                paint.setColor(Color.RED);
                break;
        }
    }

}
