package com.omkardhage4535.math_master;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;




public class about extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String PERMISSION_INTERNET = Manifest.permission.INTERNET;

    Button to_pp,to_pf;
    boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        to_pp=findViewById(R.id.to_policy);
        to_pf=findViewById(R.id.to_portfolio);

        // Request internet permission at runtime
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PERMISSION_REQUEST_CODE);
        } else {
            // Permission already granted, proceed with your code
            check=true;
            Toast.makeText(this,"given "+check,Toast.LENGTH_SHORT).show();

        }

        to_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check){
                    String url = "https://omkardhage.me";  // URL of the web page you want to open


                    Intent intent = new Intent(about.this, WebViewActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);

                }
                Toast.makeText(about.this,"Internet Permission  "+check,Toast.LENGTH_SHORT).show();

            }
        });

        to_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://doc-hosting.flycricket.io/math-master-privacy-policy/545b1935-2a0c-4c0d-849c-42b19c7edc9d/privacy";  // URL of the web page you want to open


                Intent intent = new Intent(about.this, WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with your code
                check=true;
            } else {
                // Permission denied, handle accordingly (e.g., show an error message)
                check=false;
            }
        }
    }
}