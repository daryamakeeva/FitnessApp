package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {
    TextView titlepage, subtitlepage, startpage, starttext, btnexercise,
            fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle,
            fitthreedesc, fitfourtitle, fitfourdesc;

    Animation btnone, btntwo, btnfour, btnfive, btnsix;
    View divpage;
    LinearLayout fitone, fittwo, fitthree, fitfour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        //Загружаем анимацию
        btnone = AnimationUtils.loadAnimation(this, R.anim.btnone);
        btntwo = AnimationUtils.loadAnimation(this, R.anim.btntwo);
        btnfour = AnimationUtils.loadAnimation(this, R.anim.btnfour);
        btnfive = AnimationUtils.loadAnimation(this, R.anim.btnfive);
        btnsix = AnimationUtils.loadAnimation(this, R.anim.btnsix);

        //Импортируем шрифты
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        //Импортируем элементы
        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
        startpage = (TextView) findViewById(R.id.startpage);
        starttext = (TextView) findViewById(R.id.starttext);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);
        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);
        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);
        divpage = (View) findViewById(R.id.divpage);

        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);

        //Применяем шрифт
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        startpage.setTypeface(Vidaloka);
        starttext.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        fitonetitle.setTypeface(MLight);
        fitonedesc.setTypeface(MMedium);
        fittwotitle.setTypeface(MLight);
        fittwodesc.setTypeface(MMedium);
        fitthreetitle.setTypeface(MLight);
        fitthreedesc.setTypeface(MMedium);
        fitfourtitle.setTypeface(MLight);
        fitfourdesc.setTypeface(MMedium);


        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,StartWorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        //применяем анимацию
        titlepage.startAnimation(btnone);
        subtitlepage.startAnimation(btnone);
        divpage.startAnimation(btnone);
        starttext.startAnimation(btntwo);
        startpage.startAnimation(btntwo);
        fitone.startAnimation(btntwo);
        fittwo.startAnimation(btnfour);
        fitthree.startAnimation(btnfive);
        fitfour.startAnimation(btnsix);
    }
}
