package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkoutAct extends AppCompatActivity {
    TextView startpage, subtitlepage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View bgprogress;
    ImageView img;
    RotateAnimation rotate;

    private static final long START_TIME_IN_MILLIS = 4000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        // Импортируем шрифты
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        startpage = (TextView) findViewById(R.id.startpage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);
        timerValue = (TextView) findViewById(R.id.timerValue);
        btnexercise = (TextView) findViewById(R.id.btnexercise);

        img = (ImageView) findViewById(R.id.imgtimer);
        bgprogress = (View) findViewById(R.id.bgprogress);

        startpage.setTypeface(Vidaloka);
        btnexercise.setTypeface(MMedium);
        timerValue.setTypeface(MMedium);
        fitonetitle.setTypeface(MMedium);

        rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
                img.startAnimation(rotate);
                btnexercise.setText("СЛЕДУЮЩЕЕ УПРАЖНЕНИЕ");
                bgprogress.setBackgroundColor(Color.parseColor("#25293E"));
            }
        });
    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", 0, 0);
                timerValue.setText(timeLeft);
                Toast.makeText(getApplicationContext(), "СТАРТ", Toast.LENGTH_SHORT).show();
                mTimeLeftInMillis = 301000;
                continueTimer();
            }
        }.start();
        mTimerRunning = true;
    }
    private void continueTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", 0, 0);
                timerValue.setText(timeLeft);
                Toast.makeText(getApplicationContext(), "ПОЗДРАВЛЯЕМ!", Toast.LENGTH_SHORT).show();
                bgprogress.setBackgroundColor(Color.parseColor("#FF8892"));
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    }
}
