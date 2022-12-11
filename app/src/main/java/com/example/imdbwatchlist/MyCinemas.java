package com.example.imdbwatchlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyCinemas extends AppCompatActivity {
    Button call,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cinemas);
        call = findViewById(R.id.call);
        location = findViewById(R.id.call2);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("+21671747266");
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maps();


            }
        });


    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void maps (){
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=34.04448992956861,-4.997996073659796");

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
}