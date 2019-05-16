package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.ConsoleMessage;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.io.Console;

public class EditWorkAct extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise,
            fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle,
            fitthreedesc, fitfourtitle, fitfourdesc, fitfivetitle, fitfivedesc,
            workvalue, workvalue2, workvalue3, workvalue4, workvalue5;

    Button  btnadd, btnremove, btnadd2, btnremove2, btnadd3, btnremove3,
            btnadd4, btnremove4, btnadd5, btnremove5;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo;
    SharedPreferences sPref;

    Animation bttone, bttwo, bttfour, bttfive;
    String type;
    ImageView img1, img2, img3, img4, img5;

    int sumworkout = 0;
    int sumworkout2 = 0;
    int sumworkout3 = 0;
    int sumworkout4 = 0;
    int sumworkout5 = 0;

    String imgname1, imgname2, imgname3,imgname4, imgname5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_work);

        type = getIntent().getStringExtra("type");

        bttone = AnimationUtils.loadAnimation(this, R.anim.btnone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.btnfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.btnfive);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        fitone = findViewById(R.id.fitone);
        fittwo = findViewById(R.id.fittwo);

        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);

        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);
        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);
        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);
        fitfivetitle = (TextView) findViewById(R.id.fitfivetitle);
        fitfivedesc = (TextView) findViewById(R.id.fitfivedesc);
        divpage = (View) findViewById(R.id.divpage);

        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);
        btnadd2 = findViewById(R.id.btnadd2);
        btnremove2 = findViewById(R.id.btnremove2);
        btnadd3 = findViewById(R.id.btnadd3);
        btnremove3 = findViewById(R.id.btnremove3);
        btnadd4 = findViewById(R.id.btnadd4);
        btnremove4 = findViewById(R.id.btnremove4);
        btnadd5 = findViewById(R.id.btnadd5);
        btnremove5 = findViewById(R.id.btnremove5);

        workvalue = findViewById(R.id.workvalue);
        workvalue2 = findViewById(R.id.workvalue2);
        workvalue3 = findViewById(R.id.workvalue3);
        workvalue4 = findViewById(R.id.workvalue4);
        workvalue5 = findViewById(R.id.workvalue5);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);

        imgname1 = type + "1";
        imgname2 = type + "2";
        imgname3 = type + "3";
        imgname4 = type + "4";
        imgname5 = type + "5";

        int resID = getResources().getIdentifier(imgname1, "drawable", getPackageName());
        img1.setImageResource(resID);
        resID = getResources().getIdentifier(imgname2, "drawable", getPackageName());
        img2.setImageResource(resID);
        resID = getResources().getIdentifier(imgname3, "drawable", getPackageName());
        img3.setImageResource(resID);
        resID = getResources().getIdentifier(imgname4, "drawable", getPackageName());
        img4.setImageResource(resID);
        resID = getResources().getIdentifier(imgname5, "drawable", getPackageName());
        img5.setImageResource(resID);

        sPref = getSharedPreferences("WorkoutAct",MODE_PRIVATE);
        String title1 = sPref.getString(imgname1, "");
        fitonetitle.setText(title1);
        String title2 = sPref.getString(imgname2, "");
        fittwotitle.setText(title2);
        String title3 = sPref.getString(imgname3, "");
        fitthreetitle.setText(title3);
        String title4 = sPref.getString(imgname4, "");
        fitfourtitle.setText(title4);
        String title5 = sPref.getString(imgname5, "");
        fitfivetitle.setText(title5);

        sPref = getPreferences(MODE_PRIVATE);
        String desc1 = sPref.getString(imgname1 + "ment", "");
        workvalue.setText(desc1);
        String desc2 = sPref.getString(imgname2 + "ment", "");
        workvalue2.setText(desc2);
        String desc3 = sPref.getString(imgname3 + "ment", "");
        workvalue3.setText(desc3);
        String desc4 = sPref.getString(imgname4 + "ment", "");
        workvalue4.setText(desc4);
        String desc5 = sPref.getString(imgname5 + "ment", "");
        workvalue5.setText(desc5);

        sumworkout = Integer.parseInt(desc1);
        sumworkout2 = Integer.parseInt(desc2);
        sumworkout3 = Integer.parseInt(desc3);
        sumworkout4 = Integer.parseInt(desc4);
        sumworkout5 = Integer.parseInt(desc5);

        btnexercise = findViewById(R.id.btnexercise);

        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");
/*
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        fitonetitle.setTypeface(MMedium);
        fitonedesc.setTypeface(MLight);
        fittwotitle.setTypeface(MMedium);
        fittwodesc.setTypeface(MLight);

        workvalue.setTypeface(MMedium);

        btnadd.setTypeface(MMedium);
*/
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout+=1;
                workvalue.setText(sumworkout+"");
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout <= 0){
                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout-=1;
                    workvalue.setText(sumworkout+"");
                }
            }
        });

        btnadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout2+=1;
                workvalue2.setText(sumworkout2+"");
            }
        });

        btnremove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout2 <= 0){
                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout2-=1;
                    workvalue2.setText(sumworkout2+"");
                }
            }
        });
        btnadd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout3+=1;
                workvalue3.setText(sumworkout3+"");
            }
        });

        btnremove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout3 <= 0){
                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout3-=1;
                    workvalue3.setText(sumworkout3+"");
                }
            }
        });
        btnadd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout4+=1;
                workvalue4.setText(sumworkout4+"");
            }
        });

        btnremove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout4 <= 0){
                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout4-=1;
                    workvalue4.setText(sumworkout4+"");
                }
            }
        });
        btnadd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout5+=1;
                workvalue5.setText(sumworkout5+"");
            }
        });

        btnremove5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout5 <= 0){
                    Toast.makeText(getApplicationContext(), "Ошибка!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout5-=1;
                    workvalue5.setText(sumworkout5+"");
                }
            }
        });
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPref = getPreferences(MODE_PRIVATE);

                SharedPreferences.Editor ed = sPref.edit();

                ed.putString(imgname1 + "ment", workvalue.getText().toString());
                ed.putString(imgname2 + "ment", workvalue2.getText().toString());
                ed.putString(imgname3 + "ment", workvalue3.getText().toString());
                ed.putString(imgname4 + "ment", workvalue4.getText().toString());
                ed.putString(imgname5 + "ment", workvalue5.getText().toString());
                ed.commit();
                Intent a = new Intent(EditWorkAct.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                a.putExtra("type", type);
                startActivity(a);
            }
        });
/*
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);

        btnexercise.startAnimation(bttfive);
        bgprogress.startAnimation(bttfive);
  */  }
}


