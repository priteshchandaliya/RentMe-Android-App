package com.sjsu.priteshchandaliya.rentme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView text1 = (TextView) findViewById(R.id.priteshtext);
        text1.setText("Pritesh Chandaliya\n"+"pritesh.chandaliya@sjsu.edu\n"+"+1-669-245-8477");


    }

}
