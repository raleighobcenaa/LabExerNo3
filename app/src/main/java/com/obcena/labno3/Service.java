package com.obcena.labno3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        FileInputStream reader = null;
        String msg = "";
        try {
            int token; //will hold the characted that was read.
            StringBuffer buffer = new StringBuffer();
            reader = openFileInput("data1.txt");
            while((token = reader.read()) != -1){
                msg = msg + (char)token;
            }
            reader.close();
            try {
                String list[] = msg.split(",");
                ((Button) (findViewById(R.id.buttons1))).setText(list[0]);
                ((Button) (findViewById(R.id.buttons2))).setText(list[1]);
                ((Button) (findViewById(R.id.buttons3))).setText(list[2]);
                ((Button) (findViewById(R.id.buttons4))).setText(list[3]);
                ((Button) (findViewById(R.id.buttons5))).setText(list[4]);
                ((Button) (findViewById(R.id.buttons6))).setText(list[5]);
                ((Button) (findViewById(R.id.buttons7))).setText(list[6]);
                ((Button) (findViewById(R.id.buttons8))).setText(list[7]);
            } catch(Exception e){

            }


        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
        Toast.makeText(this, msg.toString(), Toast.LENGTH_SHORT).show();
    }

    public void previous(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
