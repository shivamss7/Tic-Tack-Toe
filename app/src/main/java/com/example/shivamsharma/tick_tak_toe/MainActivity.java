package com.example.shivamsharma.tick_tak_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0=circle and 1=cross
    int k=0;
    int count =0;
    int player = 0;
    int[] status = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] wins = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void click(View view) {
        LinearLayout l = (LinearLayout) findViewById(R.id.linear);
        GridLayout g = (GridLayout) findViewById(R.id.gridLayout);
        TextView t = (TextView) findViewById(R.id.textView);
        ImageView q = (ImageView) findViewById(R.id.imageView9);
        ImageView i = (ImageView) view;
        int tap = Integer.parseInt(i.getTag().toString());
        if (status[tap] == 2) {
            status[tap] = player;
            if (player == 0) {
                i.setImageResource(R.drawable.i);
                player = 1;
                count++;
            } else if (player == 1) {
                i.setImageResource(R.drawable.x);
                player = 0;
                count++;
            }
        }
        if (player == 0)
            q.setImageResource(R.drawable.i);
        else if (player == 1)
            q.setImageResource(R.drawable.x);

        for (int[] win : wins) {
            if (status[win[0]] == status[win[1]] && status[win[1]] == status[win[2]] && status[win[0]] != 2)
                if (status[win[0]] == 0) {
                    q.setImageResource(R.drawable.i);
                    g.animate().alpha(0f);
                    t.setText("has won!");
                    l.animate().alpha(1f);
                    k=1;
                } else if (status[win[0]] == 1) {
                    q.setImageResource(R.drawable.x);
                    g.animate().alpha(0f);
                    t.setText("has won!");
                    l.animate().alpha(1f);
                    k=1;
                }
            if(count == 9 && k !=1)
            {
                q.setImageResource(0);
                g.animate().alpha(0f);
                l.animate().alpha(1f);
                t.setText("Draw");
            }
        }}

    public void restart(View view)
    {
        k=0;
        count =0;
        player = 0;
        ImageView q = (ImageView)findViewById(R.id.imageView9);
        ImageView a0 =(ImageView)findViewById(R.id.imageView);
        ImageView a1 =(ImageView)findViewById(R.id.imageView1);
        ImageView a2 =(ImageView)findViewById(R.id.imageView2);
        ImageView a3 =(ImageView)findViewById(R.id.imageView3);
        ImageView a4 =(ImageView)findViewById(R.id.imageView4);
        ImageView a5 =(ImageView)findViewById(R.id.imageView5);
        ImageView a6 =(ImageView)findViewById(R.id.imageView6);
        ImageView a7 =(ImageView)findViewById(R.id.imageView7);
        ImageView a8 =(ImageView)findViewById(R.id.imageView8);

        TextView t = (TextView) findViewById(R.id.textView);
        LinearLayout l = (LinearLayout) findViewById(R.id.linear);
        GridLayout g = (GridLayout) findViewById(R.id.gridLayout);
        q.setImageResource(R.drawable.i);
        g.animate().alpha(1f);
        l.animate().alpha(0f);
        t.setText("Turn");
     int m;
        for(m=0;m<9;m++)
            status[m]=2;
        a0.setImageResource(0);
        a1.setImageResource(0);
        a2.setImageResource(0);
        a3.setImageResource(0);
        a4.setImageResource(0);
        a5.setImageResource(0);
        a6.setImageResource(0);
        a7.setImageResource(0);
        a8.setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView q = (ImageView)findViewById(R.id.imageView9);
        q.setImageResource(R.drawable.i);

    }
}
