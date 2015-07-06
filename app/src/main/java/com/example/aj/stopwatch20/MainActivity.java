package com.example.aj.stopwatch20;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



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
        }

    }
}
