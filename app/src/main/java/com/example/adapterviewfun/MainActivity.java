package com.example.adapterviewfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AdapterView
        //ex #1: Spinner with static data source
        // string array defined in strings.xml
        Spinner monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        //get currently selected item
        String currMonth = monthSpinner.getSelectedItem().toString();
        Toast.makeText(this, currMonth, Toast.LENGTH_SHORT).show();
        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //view is the row or item that was selected
                //parent is our spinner
                //position is the index of the selected item(0-base), october = 0
                //l is the id for the selected item in the datasource
                //in arrays, position==l
                String selection = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, selection, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //executed when currently selected item is deleted from the data source
            }
        });


        //adapterview example 2
        //list view with a dynamic data source
        //List<Book>
    }
}
