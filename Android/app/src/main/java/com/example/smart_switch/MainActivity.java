package com.example.smart_switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    ImageView sw1, sw2, sw3, sw4;
    CardView check, card1, card2, card3, card4, main_on, main_off;
    //Boolean cardClicked;
    private static final String TAG = "MainActivity";
    int cardClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = findViewById(R.id.check);
        sw1 = findViewById(R.id.sw1);
        sw2 = findViewById(R.id.sw2);
        sw3 = findViewById(R.id.sw3);
        sw4 = findViewById(R.id.sw4);
        main_on = findViewById(R.id.main_on);
        main_off = findViewById(R.id.main_off);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        check.setOnClickListener(v -> {
            String str1, str2, str3, str4;
            if (cardClicked == 0) {
                str1 = sw1.toString();
            }
        });

        card1.setOnClickListener(v -> {
            FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
            DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS1");

            if (cardClicked == 0) {
                myRef.setValue(1);
                sw1.setBackgroundColor(Color.parseColor("blue"));
                cardClicked = 1;
            } else if (cardClicked == 1) {
                myRef.setValue(0);
                sw1.setBackgroundColor(Color.parseColor("white"));
                cardClicked = 0;
            }
        });


//           myRef.addValueEventListener(new ValueEventListener() {
//               @Override
//               public void onDataChange(DataSnapshot dataSnapshot) {
//                   // This method is called once with the initial value and again
//                    // whenever data at this location is updated.
//                  int value = dataSnapshot.getValue(int.class);
//                    Log.d(TAG, "Value is: " + value);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//                    // Failed to read value
//                    Log.w(TAG, "Failed to read value.", error.toException());
//                }
//            });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS2");
                if (cardClicked == 0) {
                    myRef.setValue(1);
                    sw2.setBackgroundColor(Color.parseColor("blue"));
                    cardClicked = 1;
                } else if (cardClicked == 1) {
                    myRef.setValue(0);
                    sw2.setBackgroundColor(Color.parseColor("white"));
                    cardClicked = 0;

                }
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS3");
                if (cardClicked == 0) {
                    myRef.setValue(1);
                    sw3.setBackgroundColor(Color.parseColor("blue"));
                    cardClicked = 1;
                } else if (cardClicked == 1) {
                    sw3.setBackgroundColor(Color.parseColor("white"));
                    myRef.setValue(0);
                    cardClicked = 0;

                }
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS4");
                if (cardClicked == 0) {
                    myRef.setValue(1);
                    sw4.setBackgroundColor(Color.parseColor("blue"));
                    cardClicked = 1;
                } else if (cardClicked == 1) {
                    myRef.setValue(0);
                    sw4.setBackgroundColor(Color.parseColor("white"));
                    cardClicked = 0;

                }
            }
        });
        main_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://iot-led-lighting-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("IoTlab/SmartSwitch/Device1/LED_STATUS1");
                //int led_status[]= LED_STATUS1, LED_STATUS2, LED_STATUS3, LED_STATUS4;
                if (cardClicked == 0) {

                    myRef.setValue(1);
                    sw1.setBackgroundColor(Color.parseColor("blue"));
                }
            }
        });
    }
}













