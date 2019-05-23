package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainWorkAct extends AppCompatActivity {
    ImageView cardio, power, stretch, yoga;
    TextView startpage, titlepage, subtitlepage, starttext, cardiotxt,
            powertxt, stretchtxt, yogatxt;
    LinearLayout layout1, layout2;
    View divpage;
    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work);

        startpage =(TextView) findViewById(R.id.startpage);
        titlepage =(TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
        starttext =(TextView) findViewById(R.id.starttext);
        cardiotxt =(TextView) findViewById(R.id.cardiotxt);
        powertxt =(TextView) findViewById(R.id.powertxt);
        stretchtxt =(TextView) findViewById(R.id.stretchtxt);
        yogatxt =(TextView) findViewById(R.id.yogatxt);

        divpage = (View) findViewById(R.id.divpage);
        layout1 = (LinearLayout)findViewById(R.id.linearLayout);
        layout2 = (LinearLayout)findViewById(R.id.linearLayout1);

        bttone = AnimationUtils.loadAnimation(this, R.anim.btnone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.btnfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.btnfive);
        bttsix = AnimationUtils.loadAnimation(this, R.anim.btnsix);
        bttseven = AnimationUtils.loadAnimation(this, R.anim.btnseven);

        cardio = (ImageView) findViewById(R.id.cardio);
        power = (ImageView) findViewById(R.id.power);
        stretch = (ImageView) findViewById(R.id.stretch);
        yoga = (ImageView) findViewById(R.id.yoga);

        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttwo);
        divpage.startAnimation(bttfour);
        startpage.startAnimation(bttfive);
        starttext.startAnimation(bttsix);

        layout1.startAnimation(bttseven);
        layout2.startAnimation(bttseven);
        cardiotxt.startAnimation(bttseven);
        powertxt.startAnimation(bttseven);
        stretchtxt.startAnimation(bttseven);
        yogatxt.startAnimation(bttseven);

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
