package com.sjsu.priteshchandaliya.rentme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class InputScreen extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;
    ArrayAdapter<CharSequence> adapter;
    public String Serial_number;
    public String number_beds;
    public String number_baths;
    public String availability;
    //public int input = 1;
    FloorPlans fp;
    DisplayFragment df = new DisplayFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseOperations dop = new DatabaseOperations(this);
        Log.d("Database operations", "Inserting data in a row");
        //dop.InsertInformation(new FloorPlans("A", "1","1","Immediate"));
        //dop.InsertInformation(new FloorPlans("B", "2","2","Within one month"));
        //Log.d("test string value", test_string + "Data ");

        //spinner1 code
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.no_bed, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getSelectedItem()+"category selected", Toast.LENGTH_LONG).show();
                 number_beds = parent.getSelectedItem().toString();

                System.out.println(number_beds);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner2 code
        spinner1 = (Spinner) findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(this, R.array.no_bath, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getSelectedItem()+"category selected", Toast.LENGTH_LONG).show();
                number_baths = parent.getSelectedItem().toString();

                System.out.println(number_baths);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner3 code
        spinner2 = (Spinner) findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(this, R.array.availability, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getSelectedItem()+"category selected", Toast.LENGTH_LONG).show();
                availability = parent.getSelectedItem().toString();

                System.out.println(availability);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void toastmessage(View view)
    {
        final Context context =  getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Boolean res = updateDisplayImage();

        if(res)
        {
            CharSequence text = "Searching for the best option available. Please wait....";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = new Intent(this, DisplayFragment.class);
            startActivity(intent);
        }
        else
        {
//            String text1 = "Not available, please choose other option";
//            Toast toast1 = Toast.makeText(context, text1, duration);
//            toast1.show();

            AlertDialog.Builder builder = new AlertDialog.Builder(InputScreen.this);
            builder.setTitle(this.getTitle() + " do not have this option available at the moment");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id)
                {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = builder.create();
            // show it
            alertDialog.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input_screen, menu);
        return true;
    }

    public Boolean updateDisplayImage(){
        if (spinner.getSelectedItem().toString().equalsIgnoreCase("1") && spinner1.getSelectedItem().toString().equalsIgnoreCase("1")
                && spinner2.getSelectedItem().toString().equalsIgnoreCase("Immediate") ){
            df.setImageShown("A");
            return true;
        }

        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("2") && spinner1.getSelectedItem().toString().equalsIgnoreCase("2")
                && spinner2.getSelectedItem().toString().equalsIgnoreCase("Within one month"))
        {
            df.setImageShown("B");
            return true;
        }

        else if (spinner.getSelectedItem().toString().equalsIgnoreCase("3") && spinner1.getSelectedItem().toString().equalsIgnoreCase("2.5")
                && spinner2.getSelectedItem().toString().equalsIgnoreCase("Just for inquiry"))
        {
            df.setImageShown("C");
            return true;
        }
        else
        {
            return false;
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(InputScreen.this, ContactInfo.class);
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }
}
