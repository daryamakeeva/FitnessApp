package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {
    TextView titlepage, subtitlepage, startpage, starttext, btnexercise,
            fitonetitle, fitonedesc, fittwotitle, fittwodesc, fitthreetitle,
            fitthreedesc, fitfourtitle, fitfourdesc, fitfivetitle, fitfivedesc;

    Animation btnone, btntwo, btnfour, btnfive, btnsix;
    Button btnchange;
    View divpage;
    LinearLayout fitone, fittwo, fitthree, fitfour;
    SharedPreferences sPref;
    ImageView img1, img2, img3, img4, img5;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        type = getIntent().getStringExtra("type");

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
        btnchange = (Button) findViewById(R.id.btnchange);

        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);

        String imgname1 = type + "1";
        String imgname2 = type + "2";
        String imgname3 = type + "3";
        String imgname4 = type + "4";
        String imgname5 = type + "5";
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

        sPref = getPreferences(MODE_PRIVATE);
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


        sPref = getSharedPreferences("EditWorkAct",MODE_PRIVATE);
        String desc1 = sPref.getString(imgname1 + "ment", "");
        fitonedesc.setText(desc1);
        String desc2 = sPref.getString(imgname2 + "ment", "");
        fittwodesc.setText(desc2);
        String desc3 = sPref.getString(imgname3 + "ment", "");
        fitthreedesc.setText(desc3);
        String desc4 = sPref.getString(imgname4 + "ment", "");
        fitfourdesc.setText(desc4);
        String desc5 = sPref.getString(imgname5 + "ment", "");
        fitfivedesc.setText(desc5);

            //Применяем шрифт
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);

        btnexercise.setTypeface(MMedium);

        fitonetitle.setTypeface(MLight);
        fitonedesc.setTypeface(MMedium);
        fittwotitle.setTypeface(MLight);
        fittwodesc.setTypeface(MMedium);
        fitthreetitle.setTypeface(MLight);
        fitthreedesc.setTypeface(MMedium);
        fitfourtitle.setTypeface(MLight);
        fitfourdesc.setTypeface(MMedium);

        fitfivetitle.setTypeface(MLight);
        fitfivedesc.setTypeface(MMedium);



        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,StartWorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,EditWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                a.putExtra("type", type);
                startActivity(a);
            }
        });
        //применяем анимацию
        /*
        titlepage.startAnimation(btnone);
        subtitlepage.startAnimation(btnone);
        divpage.startAnimation(btnone);

        fitone.startAnimation(btntwo);
        fittwo.startAnimation(btnfour);
        fitthree.startAnimation(btnfive);
        fitfour.startAnimation(btnsix);
    */}
}
