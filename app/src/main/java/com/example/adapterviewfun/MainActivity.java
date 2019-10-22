package com.example.adapterviewfun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = parent.getItemAtPosition(position).toString();
                //show an alert dialog
                //use AlertDialog.Builder class and method chaining
                AlertDialog.Builder alertBuilder =
                        new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setTitle("item clicked")
                        .setMessage("You clicked: " + selection)
                        .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("TAG", "onClick: okay clicked");
                                Toast.makeText(MainActivity.this, "okay", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Dismiss", null)
                        .show();
                //on clicking outside it doesn't do any of the three
                //onResume()?
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //return if this method 'consumed' this event
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return true; //so the onItemClick is not also called
            }
        });

        //list of book
        //copy/paste book.java into this project
        List<Book> books = new ArrayList<>();
        books.add(new Book("book 1", "Bob", 30));
        books.add(new Book("book 2", "Larry", 33));
        books.add(new Book("book 3", "Joe", 25));
        books.add(new Book());

        //what does an adapter do?
        //data source <-> array adapter <-> spinner/listview
        //set up an array adapter to be the middleman between our datasource, books, and the adapterview  listview
        ArrayAdapter<Book> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //the view for each item in a row of the list view
                books //datasource
        );
        listView.setAdapter(arrayAdapter);


        //dynamic datasource
        books.remove(1);
        //force an update
        arrayAdapter.notifyDataSetChanged();


        //alert dialog

    }


}
