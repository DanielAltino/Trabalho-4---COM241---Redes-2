package com.example.genreciadordeenergia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLed;
    private TextView txtLed;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgLed = findViewById(R.id.imageViewLED);
        txtLed = findViewById(R.id.textViewLED);
        txtLed.setText("DESLIGADO");

        imgLed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtLed.getText().toString().equals("LIGADO")){
                    imgLed.setImageResource(R.drawable.desligado);
                    txtLed.setText("DESLIGADO");
                    myRef.child("LED_STATUS").setValue("OFF");
                }
                else{
                    imgLed.setImageResource(R.drawable.ligado);
                    txtLed.setText("LIGADO");
                    myRef.child("LED_STATUS").setValue("ON");
                }
            }
        });



    }
}
