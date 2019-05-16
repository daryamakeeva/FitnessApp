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
    ImageView cardio;
    TextView startpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_work);

        startpage =(TextView) findViewById(R.id.startpage);

        //Context context = getBaseContext();
        //context.deleteDatabase("app.db");
/*
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS cardio (id INTEGER, name TEXT, description TEXT, time INTEGER, img TEXT)");
        db.execSQL("INSERT INTO cardio VALUES(1, 'Бег с подниманием колена', '', 1, 'cardio1')");
        db.execSQL("INSERT INTO cardio VALUES(2, 'Конькобежец', '', 1, 'cardio2')");
        db.execSQL("INSERT INTO cardio VALUES(3, 'Выпады со сменой ног', '', 1, 'cardio3')");
        db.execSQL("INSERT INTO cardio VALUES(4, 'Присед с выпрыгиванием', '', 1, 'cardio4')");
        db.execSQL("INSERT INTO cardio VALUES(5, 'Берпи', '', 1, 'cardio5')");

        Cursor query = db.rawQuery("SELECT * FROM cardio;", null);
        if (query.moveToFirst()){
            do {
                String name = query.getString(4);
                startpage.setText(name);
            }
            while (query.moveToNext());
        }
        db.close();
*/
        cardio = (ImageView) findViewById(R.id.cardio);

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainWorkAct.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                a.putExtra("type", "cardio");
                startActivity(a);
            }
        });
    }
}
