package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button on;
    Button off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        on = findViewById(R.id.button_on);
        off = findViewById(R.id.button_off);

      on.setOnClickListener(view -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
            DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS");
          //DatabaseReference myRef1 = database.getReference("IoTlab/SmartSwitch/Device1/STRING_STATUS");
            myRef.setValue(1);
           // myRef1.setValue(1);
        });
        off.setOnClickListener(view -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
            DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS");
           // DatabaseReference myRef1 = database.getReference("IoTlab/SmartSwitch/Device1/STRING_STATUS");
            myRef.setValue(0);
            //myRef1.setValue(0);
            // Write a message to the database.
        });
    }
}
