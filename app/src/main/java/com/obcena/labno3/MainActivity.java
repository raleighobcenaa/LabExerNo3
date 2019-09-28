package com.obcena.labno3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    EditText school1, school2, school3, school4, school5,
            school6, school7, school8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        school1 = findViewById(R.id.school1);
        school2 = findViewById(R.id.school2);
        school3 = findViewById(R.id.school3);
        school4 = findViewById(R.id.school4);
        school5 = findViewById(R.id.school5);
        school6 = findViewById(R.id.school6);
        school7 = findViewById(R.id.school7);
        school8 = findViewById(R.id.school8);

    }

    public void writeData (View v){
       String school1Data = school1.getText().toString() + ",";
       String school2Data = school2.getText().toString() + ",";
       String school3Data  = school3.getText().toString() + ",";
       String school4Data  = school4.getText().toString() + ",";
       String school5Data  = school5.getText().toString() + ",";
       String school6Data  = school6.getText().toString() + ",";
       String school7Data  = school7.getText().toString() + ",";
       String school8Data  = school8.getText().toString() + ",";
       FileOutputStream writer = null;
       try {
           writer = openFileOutput("data1.txt", MODE_PRIVATE);
           writer.write(school1Data.getBytes());
           writer.write(school2Data.getBytes());
           writer.write(school3Data.getBytes());
           writer.write(school4Data.getBytes());
           writer.write(school5Data.getBytes());
           writer.write(school6Data.getBytes());
           writer.write(school7Data.getBytes());
           writer.write(school8Data.getBytes());

       } catch(FileNotFoundException e) {
           Log.d("Error", "File not found.");
       } catch (IOException e) {
           Log.d("Error", "IO Error.");
       } finally {
           try {
               writer.close();
           } catch (IOException e) {
               Log.d("Error", "File not found.");
           }
       }
       Toast.makeText(this, "Data is saved.", Toast.LENGTH_LONG).show();

    }

    public void displayData (View v){
        String buffer = "";
        try {
            int token; //will hold the characted that was read.
            FileInputStream reader = openFileInput("data1.txt");
            while((token = reader.read()) != -1){
                buffer = buffer + (char)token;
            }
        } catch (FileNotFoundException e) {
            Log.d("Error", "File not found.");
        } catch (IOException e) {
            Log.d("Error", "IO Error.");
        }
        Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();
    }

    public void next(View v){
        Intent i = new Intent(this, Service.class);
        startActivity(i);
    }
}
