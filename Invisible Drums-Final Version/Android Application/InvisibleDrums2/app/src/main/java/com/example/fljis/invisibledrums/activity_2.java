package com.example.fljis.invisibledrums;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    //static String databasefolder = "/home/pi/Desktop/InvisibleDrums1/sound packs/";

    //private UDPSender sender = new UDPSender();

    public void addTone(View view)  {

        UDPSender sender = new UDPSender("0",1236);
//        sender.setCommand("0");
        Thread thrd = new Thread(sender);
        thrd.start();
        //thrd.run();
//        sender.setOpcode(1236);
        //String command = "0";
       // sender.send( "0",1236);
        //sender.run();


    }
    public void deleteTone(View view) {
        UDPSender sender = new UDPSender("1",1236);
//        sender.setCommand("1");
//        sender.setOpcode(1236);
        Thread thrd = new Thread(sender);
        thrd.start();
        //sender.run();
        //String command = "1";
        //sender.send(command, 1236);


    }
    public void setTone(View view) {
        UDPSender sender = new UDPSender("2",1236);
//        sender.setCommand("2");
//        sender.setOpcode(1236);
        Thread thrd = new Thread(sender);
        thrd.start();
        //sender.run();

        //String command = "2";
        //sender.send(comand, 1236);

    }


    public void SwitchScreen (View view) {
        Intent intent = new Intent(this, activity_3.class);
        startActivity(intent);
    }

}
