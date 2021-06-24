package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Switch switch1, Switch2, Switch3, Switch4;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);
        Switch2 = findViewById(R.id.Switch2);
        Switch3 = findViewById(R.id.Switch3);
        Switch4 = findViewById(R.id.Switch4);

        btnGet = (Button)findViewById(R.id.getBtn);
        btnGet.setOnClickListener(v -> {
            String str1, str2, str3, str4;
            if (switch1.isChecked())
                str1 = switch1.getTextOn().toString();
            else
                str1 = switch1.getTextOff().toString();
            if (Switch2.isChecked())
                str2 = Switch2.getTextOn().toString();
            else
                str2 = Switch2.getTextOff().toString();
            if (Switch3.isChecked())
                str3 = Switch3.getTextOn().toString();
            else
                str3 = Switch3.getTextOff().toString();
            if (Switch4.isChecked())
                str4 = Switch4.getTextOn().toString();
            else
                str4 = Switch4.getTextOff().toString();


            Toast.makeText(getApplicationContext(), "Bulb1 is -  " + str1 + " " +
                    "\n" + "Bulb2 is -  " + str2 + "" +
                    " \n" + "Bulb3 is -  " + str3 + "" +
                    " \n" + "Bulb4 is -  " + str4 + "" +
                    " \n", Toast.LENGTH_SHORT).show();

            switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS1");
                if (isChecked) {

                    myRef.setValue(1);

                } else {
                    myRef.setValue(0);

                }
            });
            Switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS2");
                if (isChecked) {

                    myRef.setValue(1);

                } else {
                    myRef.setValue(0);

                }
            });
            Switch3.setOnCheckedChangeListener((buttonView, isChecked) -> {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS3");
                if(isChecked){

                    myRef.setValue(1);

                }else{
                    myRef.setValue(0);

                }
            });
            Switch4.setOnCheckedChangeListener((buttonView, isChecked) -> {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS4");
                if(isChecked){

                    myRef.setValue(1);

                }else{
                    myRef.setValue(0);

                }
            });
        });
    }
}
