package com.example.fljis.invisibledrums;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.lang.*;

import java.util.ArrayList;

public class activity_3 extends AppCompatActivity {
    public static final int MY_PERMISSION_REQUEST = 1;

    ArrayList<String> arrayList;

    ListView listView;

    ArrayAdapter<String> adapter;
    String filename;
    String tonePath;






    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        if(ContextCompat.checkSelfPermission(activity_3.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) !=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity_3.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(activity_3.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
            else{
                ActivityCompat.requestPermissions(activity_3.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
        }
            else {
                doStuff();
            }
        }

//    public void sendTone(View view) {
//        UDPSender sender = new UDPSender("filename", 1236);
////        sender.setCommand("2");
////        sender.setOpcode(1236);
//        sender.run();
//    }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void doStuff()  {
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        getMusic();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int pos, long l)  {
                listView.getItemAtPosition(pos);



                String filename =  arrayList.get(pos)+".wav";
                tonePath ="/storage/emulated/0/DrumTones/"+filename;
                UDPSender sender = new UDPSender(filename,1237);
                FileClient filesender = new FileClient();
                filesender.setCommand(tonePath);

                Thread thrd = new Thread(sender);
                Thread thrd2 = new Thread(filesender);


                thrd.start();


                //thrd.run();

                if(!tonePath.isEmpty()) {
                    //thrd2.run();
                    thrd2.start();

              }
                Log.d("ITEM CLICKED", "onItemClick: " + tonePath);
                Log.d("ITEM CLICKED", "onItemClick: " + filename);



               //thrd2.run();

            }
        });
        }




    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getMusic(){
        ContentResolver contentResolver = getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);


        if(songCursor != null && songCursor.moveToFirst()) {
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int songLocation = songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);

            do {
                String currentTitle = songCursor.getString(songTitle);
                String currentArtist = songCursor.getString(songArtist);
                String currentLocation = songCursor.getString(songLocation);

                arrayList.add(currentTitle);

            } while (songCursor.moveToNext());
        }

            }
           //@Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onRequestPermissionResult(int requesCode, String[] permissions, int[] grantResults) {
        switch (requesCode){
            case MY_PERMISSION_REQUEST: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(activity_3.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();

                        doStuff();
                    }
                }
                else {
                    Toast.makeText(this, "No Permission Granted!", Toast.LENGTH_SHORT).show();
                    finish();

                }
                return;
                }
            }


//    public void addTone(View view)  {
//        String filename =
//        UDPSender sender = new UDPSender("0",1237);
////        sender.setCommand("0");
//        Thread thrd = new Thread(sender);
//        thrd.run();
////        sender.setOpcode(1236);
//        //String command = "0";
//        // sender.send( "0",1236);
//        //sender.run();


    }



}
