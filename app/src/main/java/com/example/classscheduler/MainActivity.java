/*
AUTHOR:
ASSIGNMENT:
DATE:

For this assignment you will learn and practice with the ListView.
Examine the code and comments found below and test it our on your own emulator.

ASSIGNMENT DETAILS:
-Modify the project to do the following:
    -User will be able to select a class from the list and build their own schedule
    -User will make 5 selections to build a schedule
    -Make a list of at least 10 unique class names (be creative!, but appropriate please :))
    -User cannot select the same class twice
    -Final schedule can resemble this:
        CLASS 1: class_name
        CLASS 2: class_name
        CLASS 3: class_name
        CLASS 4: class_name
        CLASS 5: class_name
    -OR, for advanced students, you can build a proper weekly schedule with days/times

NOTE: The strings.xml file can be found in app->res->values->values

*/

package com.example.classscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView list_view; //java variable storing the ListView
    String[] classes; //regular String array
    ArrayAdapter<String> adapter; //something new! we'll get into this later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the ListView - take note of the casting!
        list_view = (ListView) findViewById(R.id.list);
        //next we get the String array inside the .xml file called Strings.xml and set it
        //inside a Java String array
        //NOTE: The strings.xml file can be found in app->res->values->values
        classes = getResources().getStringArray(R.array.classes);
        //need an adapter
        //an adapter falls in between the data source (arrays, etc) and the XML layout (views, etc)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
        //sets the adapter
        list_view.setAdapter(adapter);

        //an event listener for the list
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //the event handler
            //gets the element from the String array and casts it to a String to work with
            //"Toast" messages are small notifications you can have pop up in your apps
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String class_name = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "you selected " +class_name, Toast.LENGTH_LONG).show();
            }
        });

    }
}
