package com.example.edmon.pianotiles2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class TilesActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
            btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20;

    int programCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        btn1 = (Button) findViewById(R.id.buttonZero);
        btn2 = (Button) findViewById(R.id.buttonOne);
        btn3 = (Button) findViewById(R.id.buttonTwo);
        btn4 = (Button) findViewById(R.id.buttonThree);
        btn5 = (Button) findViewById(R.id.buttonFour);
        btn6 = (Button) findViewById(R.id.buttonFive);
        btn7 = (Button) findViewById(R.id.buttonSix);
        btn8 = (Button) findViewById(R.id.buttonSeven);
        btn9 = (Button) findViewById(R.id.buttonEight);
        btn10 = (Button) findViewById(R.id.buttonNine);
        btn11 = (Button) findViewById(R.id.buttonTen);
        btn12 = (Button) findViewById(R.id.buttonOneOne);
        btn13 = (Button) findViewById(R.id.buttonOneTwo);
        btn14 = (Button) findViewById(R.id.buttonOneThree);
        btn15 = (Button) findViewById(R.id.buttonOneFour);
        btn16 = (Button) findViewById(R.id.buttonOneFive);
        btn17 = (Button) findViewById(R.id.buttonOneSix);
        btn18 = (Button) findViewById(R.id.buttonOneSeven);
        btn19 = (Button) findViewById(R.id.buttonOneEight);
        btn20 = (Button) findViewById(R.id.buttonOneNine);

        /*
         * Setting up the bottom four buttons to be clickable
         */
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);


        /*
         * Setting up color tags. This is necessary since there's no good way to compare the
         * background of a tile to anything else.
         */
        btn1.setBackgroundResource(R.drawable.black_tile);
        btn1.setTag("BLACK");
        btn2.setBackgroundResource(R.drawable.white_tile);
        btn3.setBackgroundResource(R.drawable.white_tile);
        btn4.setBackgroundResource(R.drawable.white_tile);


        btn5.setBackgroundResource(R.drawable.white_tile);
        btn6.setBackgroundResource(R.drawable.white_tile);
        btn7.setBackgroundResource(R.drawable.black_tile);
        btn7.setTag("BLACK");
        btn8.setBackgroundResource(R.drawable.white_tile);

        btn9.setBackgroundResource(R.drawable.white_tile);
        btn10.setBackgroundResource(R.drawable.black_tile);
        btn10.setTag("BLACK");
        btn11.setBackgroundResource(R.drawable.white_tile);
        btn12.setBackgroundResource(R.drawable.white_tile);

        btn13.setBackgroundResource(R.drawable.white_tile);
        btn14.setBackgroundResource(R.drawable.white_tile);
        btn15.setBackgroundResource(R.drawable.white_tile);
        btn16.setBackgroundResource(R.drawable.black_tile);
        btn16.setTag("BLACK");


        btn17.setBackgroundResource(R.drawable.black_tile);
        btn17.setTag("BLACK");
        btn18.setBackgroundResource(R.drawable.white_tile);
        btn19.setBackgroundResource(R.drawable.white_tile);
        btn20.setBackgroundResource(R.drawable.white_tile);

    }


    private void gameWin() {
        finishActivity(true);
    }

    private void gameLost() {
        finishActivity(false);
    }

    private void finishActivity(boolean result) {
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        Button[] firstRow = new Button[]{btn1, btn2, btn3, btn4};
        Button[] secondRow = new Button[]{btn5, btn6, btn7, btn8};
        Button[] thirdRow = new Button[]{btn9, btn10, btn11, btn12};
        Button[] fourthRow = new Button[]{btn13, btn14, btn15, btn16};
        Button[] fifthRow = new Button[]{btn17, btn18, btn19, btn20};
        int[] blackPosition = new int[5];
        Random rand = new Random();


        blackPosition[0] = findBlack(firstRow);
        blackPosition[1] = findBlack(secondRow);
        blackPosition[2] = findBlack(thirdRow);
        blackPosition[3] = findBlack(fourthRow);
        blackPosition[4] = findBlack(fifthRow);

        String color = (String) v.getTag();
        if (color.equals("BLACK")) {
            changeColors(firstRow, rand.nextInt(4));
            changeColors(secondRow, blackPosition[0]);
            changeColors(thirdRow, blackPosition[1]);
            changeColors(fourthRow, blackPosition[2]);
            changeColors(fifthRow, blackPosition[3]);
        } else {
            gameLost();
        }
        programCounter++;

        if (programCounter == 10) {
            gameWin();
        }
    }

    /**
     * Searches the array for the button that has a "BLACK" tag.
     */
    public int findBlack(Button[]a){
        int position = -1;
        for (int i = 0; i < a.length; i++) {
            String color = (String) a[i].getTag();
            if (color.equals("BLACK")){
                position = i;
            }
        }
        return position;
    }


    /**
     * Changes the button at index to black, makes every other tile white.
     */
    public void changeColors(Button[]b, int index){
        for(int i = 0; i < b.length; i++){
            if (i==index){
                b[i].setBackgroundResource(R.drawable.black_tile);
                b[i].setTag("BLACK");
            }
            else {
                b[i].setBackgroundResource(R.drawable.white_tile);
                b[i].setTag(" ");
            }
        }
    }

}
