package com.example.aj.stopwatch20;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    // For expandable list view
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    /** Start Activity Lifecycle Methods**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the expandable listview
        expListView = (ExpandableListView) findViewById(R.id.projExpandableListView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

    }//END onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//END onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // TODO
        // Add correct icons for search and newproj
        // Add clicking functionality for search and newproj and settings
        // Add data analysis, backup, export options (overflow options)

        // Used for toasts
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_settings:
                // Open settings activity
                return true;
            case R.id.action_search:
                // Open search
                // Toast user for testing
                CharSequence text1 = "Search!";

                Toast toast1 = Toast.makeText(context, text1, duration);
                toast1.show();
                return true;
            case R.id.action_newproj:
                // Open new project dialog
                // Toast user for testing
                CharSequence text2 = "New project!";

                Toast toast2 = Toast.makeText(context, text2, duration);
                toast2.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//END Switch Case
    }//END onOptionsItemSelected

    /** End Activity Lifecycle Methods**/


    /*
    * Preparing the list data
    */
    private void prepareListData() {
        // TODO
        /*
        * Get project names from database
        * Get Time Worked from database
        * Get Notes from database
        * Add more ProjectProperties
        */
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Project 1");
        listDataHeader.add("Project 2");
        listDataHeader.add("Project 3");

        // Adding child data
        List<String> ProjectProperties = new ArrayList<String>();
        ProjectProperties.add("Time Worked");
        ProjectProperties.add("Notes");

        listDataChild.put(listDataHeader.get(0), ProjectProperties); // Header, Child data
        listDataChild.put(listDataHeader.get(1), ProjectProperties);
        listDataChild.put(listDataHeader.get(2), ProjectProperties);
    }//END prepareListData

}// END MainActivity
