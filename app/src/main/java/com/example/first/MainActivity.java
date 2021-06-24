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
    private Switch switch1;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);

        switch1 = findViewById(R.id.switch1);

        btnGet = (Button)findViewById(R.id.getBtn);
        btnGet.setOnClickListener(v -> {
            String str1, str2;
            if (switch1.isChecked())
                str1 = switch1.getTextOn().toString();
            else
                str1 = switch1.getTextOff().toString();

            Toast.makeText(getApplicationContext(), "Switch1 -  " + str1 + " \n", Toast.LENGTH_SHORT).show();

            switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS");
                if(isChecked){

                    myRef.setValue(1);

                }else{
                    myRef.setValue(0);

                }
            });
        });
    }
}
