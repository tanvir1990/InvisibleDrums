/*
 * UDPReceiver is used to receive the Operation commands
 * SYSC 3010 M-7
 * @author Md Farhan Labib
 * 
 * @since 2018-12-03
 */
package com.example.fljis.invisibledrums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchScreen (View view){
        Intent intent = new Intent(this, activity_2.class);
        startActivity(intent);
    }

   }


