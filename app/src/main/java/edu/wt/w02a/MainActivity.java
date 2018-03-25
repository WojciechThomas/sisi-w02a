package edu.wt.w02a;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public static final String MY_SETTINGS = "MySettings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(MY_SETTINGS, MODE_PRIVATE);
        String savedString = settings.getString("savedString", "brak");
        TextView tv = (TextView)findViewById(R.id.savedString);
        tv.setText(savedString);
    }

    @Override
    protected void onStop() {
        super.onStop();

        TextView tv = (TextView) findViewById(R.id.savedString);
        String str = tv.getText().toString();
        SharedPreferences settings = getSharedPreferences(MY_SETTINGS, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("savedString", str);
        editor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickSave(View v) {
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

    }
}
