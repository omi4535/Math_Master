package com.omkardhage4535.math_master;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class multi_act extends AppCompatActivity {

    // component declaration

    private static final int start_timer = 30000;
    public int time_left = start_timer;
    TextView operation_addition;
    TextView score, lives, timer_text;
    EditText ans;
    Button check, move;

    // required variable
    View v;
    TextView c_msg;
    int act_score = 0, act_lives = 3;

    // timer
    boolean attempt = false, checked = false;
    int n1, n2;
    CountDownTimer timer;
    Boolean timer_running;
//    private MediaPlayer mediaback;

    @Override
    public void onBackPressed() {
        game_reset();
        Intent after_gameover = new Intent(multi_act.this, MainActivity.class);
        startActivity(after_gameover);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);


        // finding component with their ID's
//        mediaback = MediaPlayer.create(this, R.raw.background_1);
//        mediaback.setLooping(true);
//        mediaback.start();

        operation_addition = findViewById(R.id.opration_add);
        score = findViewById(R.id.add_score);
        lives = findViewById(R.id.add_live);
        ans = findViewById(R.id.add_ans);
        check = findViewById(R.id.add_check);
        move = findViewById(R.id.add_move);
        timer_text = findViewById(R.id.timer);
        v = findViewById(R.id.mback);
        c_msg = findViewById(R.id.congro_msg);


        // objects of required classes

        MainActivity ma = new MainActivity();
        helper_class help = new helper_class();

        // initial setting of score and lives

        score.setText("" + act_score);
        lives.setText("" + act_lives);

        //finding two random nos

        Random r = new Random();
        game_reset();

        // intent to go to game over activity

        Intent after_gameover = new Intent(multi_act.this, game_over.class);

        // check
        check.requestFocus();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                timer_pasue();

                //getting ans from user and convert to integer


                //checking user has given ans or not?

                if (!ans.getText().toString().trim().isEmpty()) {
                    String isgiven = ans.getText().toString();
                    int ur_ans = Integer.parseInt(ans.getText().toString());
                    attempt = true;
                    ans.setText(null);

                    //checking entered ans is correct or not?

                    if (helper_class.help_check(n1 * n2, ur_ans)) {

                        // if ans is correct score +10
//                        mediaback.start();
                        act_score += 10;
                        score.setText("" + act_score);
                        operation_addition.setText("");
                        c_msg.setText("congro");
                        int[] back_images = new int[]{R.drawable.img_2};
                        v.setBackground(ContextCompat.getDrawable(getApplicationContext(), back_images[0]));
                        MediaPlayer medias = MediaPlayer.create(multi_act.this, R.raw.success);
                        medias.start();
                    } else {
                        // if wrong then decrease in live by one
                        MediaPlayer median = MediaPlayer.create(multi_act.this, R.raw.negative);
                        median.start();
                        act_lives -= 1;
                        checked = true;

                        if (act_lives <= 0) {
                            // going to game over activity if live reaches 0
                            after_gameover.putExtra("result", act_score);
                            startActivity(after_gameover);
                            finish();
                        }
                        lives.setText("" + act_lives);
                        c_msg.setText("Try Again");
                        operation_addition.setText("");

                        int[] back_images = new int[]{R.drawable.img_3};
                        v.setBackground(ContextCompat.getDrawable(getApplicationContext(), back_images[0]));


                    }
                } else {
                    Toast.makeText(multi_act.this, "enter your answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // move


        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                timer_reset();

                // checking for ans is check or not?

                if (checked) {
                    // if checked then reset task
                    game_reset();
                } else {
                    // if not checked then reset task


                    // want to move forward without attempting

                    if (attempt) {

                        // if attempted and want to move forward

                        game_reset();
                    } else {

                        // want to move forward without attempting

                        act_lives -= 1;
                        if (act_lives <= 0) {
                            after_gameover.putExtra("result", act_score);
                            startActivity(after_gameover);
                            finish();
                        }
                        lives.setText("" + act_lives);

                        game_reset();
                    }


                }

                // reset of flags

                attempt = false;
                checked = false;
            }
        });


    }

    void game_reset() {
        int[] back_images = new int[]{R.drawable.img_1};
        v.setBackground(ContextCompat.getDrawable(getApplicationContext(), back_images[0]));
        c_msg.setText("");
        n1 = helper_class.random_on(100);
        n2 = helper_class.random_on(100);
        operation_addition.setText("" + n1 + " X " + n2);
//        timer_reset();
//        start_timer();
    }
//
//    public void start_timer() {
//        timer = new CountDownTimer(time_left, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                time_left = Math.toIntExact(millisUntilFinished / 1000);
//                timer_text.setText("time : " + time_left);
//            }
//
//            @Override
//            public void onFinish() {
//                timer_running = false;
//                timer_pasue();
//                timer_reset();
//                act_lives -= 1;
//                attempt = true;
//                Intent after_gameover = new Intent(multi_act.this, game_over.class);
//                if (act_lives <= 0) {
//                    after_gameover.putExtra("result", act_score);
//                    startActivity(after_gameover);
//                    finish();
//                }
//                lives.setText("" + act_lives);
//                operation_addition.setText("Sorry time up");
//            }
//        }.start();
//        timer_running = true;
//    }
//
//    public void timer_pasue() {
//        timer.cancel();
//        timer_running = false;
//    }
//
//    public void timer_reset() {
//        time_left = start_timer;
//        timer_text.setText("time : " + time_left);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mediaback.stop();
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mediaback.stop();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mediaback.start();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        mediaback.start();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mediaback.start();
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
}