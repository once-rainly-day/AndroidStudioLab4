package com.example.androidstudiolab4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab4_var1);
        ListView lv = findViewById(R.id.lv);
        String[] strArray = new String[249];
        for (int i = 1; i <= Arrays.stream(strArray).count(); i++) {
            strArray[i - 1] = "Число " + (i * i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            if (position < strArray.length) {
                String selectedItem = strArray[position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}