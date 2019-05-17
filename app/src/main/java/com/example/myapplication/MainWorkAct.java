package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class MainWorkAct extends AppCompatActivity {
    ImageView cardio, power, stretch, yoga;
    TextView startpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work);

        startpage =(TextView) findViewById(R.id.startpage);
        cardio = (ImageView) findViewById(R.id.cardio);
        power = (ImageView) findViewById(R.id.power);
        stretch = (ImageView) findViewById(R.id.stretch);
        yoga = (ImageView) findViewById(R.id.yoga);

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                a.putExtra("type", "cardio");
                a.putExtra("id", 0);
                startActivity(a);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                a.putExtra("type", "power");
                a.putExtra("id", 5);
                startActivity(a);
            }
        });
        stretch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                a.putExtra("type", "stretch");
                a.putExtra("id", 10);
                startActivity(a);
            }
        });
        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                a.putExtra("type", "yoga");
                a.putExtra("id", 15);
                startActivity(a);
            }
        });
    }
}
