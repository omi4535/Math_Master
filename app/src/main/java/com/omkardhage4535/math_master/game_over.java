package com.omkardhage4535.math_master;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class game_over extends AppCompatActivity {

    Button exit, restart;
    TextView final_score;
    MediaPlayer back;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitalert = new AlertDialog.Builder(game_over.this);
        exitalert.setTitle("Exit");
        exitalert.setMessage("do you really want to exit");
        exitalert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        exitalert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog al = exitalert.create();
        al.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        back = MediaPlayer.create(this, R.raw.backmusic_for_game_over);
        back.setLooping(true);
        back.start();
        exit = findViewById(R.id.exit);
        restart = findViewById(R.id.restart);
        final_score = findViewById(R.id.textView2);
        Intent getintent = getIntent();
        int final_sore = getintent.getIntExtra("result", 0);
        final_score.setText("" + final_sore);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder exitalert = new AlertDialog.Builder(game_over.this);
                exitalert.setTitle("Exit");
                exitalert.setMessage("do you really want to exit");
                exitalert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                exitalert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog al = exitalert.create();
                al.show();

            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_home = new Intent(game_over.this, MainActivity.class);
                startActivity(goto_home);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        back.stop();

    }

    @Override
    protected void onStop() {
        super.onStop();
        back.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        back.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        back.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        back.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        back.stop();
    }
}