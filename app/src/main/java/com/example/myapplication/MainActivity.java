package com.example.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    Animation animimgpage, btnone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Загружаем анимацию
        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage);
        btnone = AnimationUtils.loadAnimation(this, R.anim.btnone);

        //Импортируем шрифты
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage =(TextView) findViewById(R.id.subtitlepage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        imgpage = (ImageView) findViewById(R.id.imgpage);

        //Применяем к titlepage шрифт
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        //Экспорт анимации
        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(btnone);
        subtitlepage.startAnimation(btnone);
    }
}
