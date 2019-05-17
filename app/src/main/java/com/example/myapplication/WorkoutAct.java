package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    String type;
    int id;

    int[] img = new int[]{R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5 };
    int[] title = new int[]{R.id.fitonetitle, R.id.fittwotitle, R.id.fitthreetitle,
            R.id.fitfourtitle, R.id.fitfivetitle};
    int[] desc = new int[]{R.id.fitonedesc, R.id.fittwodesc, R.id.fitthreedesc,
            R.id.fitfourdesc, R.id.fitfivedesc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        type = getIntent().getStringExtra("type");
        id = getIntent().getIntExtra("id", 0);

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

        divpage = (View) findViewById(R.id.divpage);
        btnchange = (Button) findViewById(R.id.btnchange);

        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);

        DataBase dbHelp = new DataBase(this);
        SQLiteDatabase db = dbHelp.getWritableDatabase();
        String where = "type" + " LIKE '%" + type + "%'";
        String[] whereArgs = new String[]{where};

        String sqlSelect = "SELECT * FROM train WHERE type='" + type + "';";
        Cursor query = db.rawQuery(sqlSelect, null);
        int i = 0;
        if (query.moveToFirst()){
            do {
                TextView myView = (TextView) findViewById(title[i]);
                TextView myDesc = (TextView) findViewById(desc[i]);
                ImageView myImg = (ImageView) findViewById(img[i]);

                String name = query.getString(query.getColumnIndex("name"));
                String img = query.getString(query.getColumnIndex("img"));
                int time = query.getInt(query.getColumnIndex("time"));

                utilFunc func = new utilFunc();
                String desc = func.choosePluralMerge(time, "минута", "минуты", "минут");


                int resID = getResources().getIdentifier(img, "drawable", getPackageName());

                myView.setText(name);
                myImg.setImageResource(resID);
                myDesc.setText(desc);

                myView.setTypeface(MLight);
                myDesc.setTypeface(MMedium);
                i++;
            }
            while (query.moveToNext());
        }
        sqlSelect = "SELECT * FROM types WHERE type='" + type + "';";
        query = db.rawQuery(sqlSelect, null);

        i = 0;
        if (query.moveToFirst()){
            do {
                String type_name = query.getString(query.getColumnIndex("name"));
                String desc = query.getString(query.getColumnIndex("description"));
                titlepage.setText(type_name);
                subtitlepage.setText(desc);
                i++;
            }
            while (query.moveToNext());
        }



        db.close();

            //Применяем шрифт
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);

        btnexercise.setTypeface(MMedium);


        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,StartWorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                a.putExtra("type", type);
                a.putExtra("cnt", 0);
                a.putExtra("id", id);
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
