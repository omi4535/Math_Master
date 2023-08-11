package com.omkardhage4535.math_master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public int lives_remain = 3;
    Button add, mul, sub, about;
//    MediaPlayer mediaPlayer;

//    @Override
//    protected void onPause() {
//        super.onPause();
//        mediaPlayer.stop();
//
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        mediaPlayer.stop();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mediaPlayer.start();
//    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        mediaPlayer.start();
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mediaPlayer.start();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.addition);
        sub = findViewById(R.id.subtraction);
        mul = findViewById(R.id.multi);
        about = findViewById(R.id.about);

//        mediaPlayer = MediaPlayer.create(this, R.raw.background_1);
//        mediaPlayer.setLooping(true);
        Intent toadd_activity = new Intent(MainActivity.this, addition_act.class);
      Intent tosub_activity = new Intent(MainActivity.this, subtraction_act.class);
        Intent tomulti_activity = new Intent(MainActivity.this, multi_act.class);
       Intent toabout_activity = new Intent(MainActivity.this, about.class);

//        mediaPlayer.start();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.stop();
                startActivity(toadd_activity);
                finish();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.stop();
                startActivity(tosub_activity);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.stop();
                startActivity(toabout_activity);
                finish();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.stop();
                startActivity(tomulti_activity);
                finish();
            }
        });


    }
}