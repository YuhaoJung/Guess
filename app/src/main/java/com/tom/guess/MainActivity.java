package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int secret;
    TextView result;
    EditText guess;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        guess = findViewById(R.id.guess);
        result = findViewById(R.id.result);
        secret =new Random().nextInt(10)+1;
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int secret2 = new Random().nextInt(10)+1;
               secret = secret2;

            }
        });
    }
    public void check(View view){
         int num = Integer.parseInt(guess.getText().toString());
         if(num>secret){
             result.setText("smaller!");
             new AlertDialog.Builder(MainActivity.this)
                     .setTitle(":(")
                     .setMessage("smaller")
                     .setPositiveButton("OK",null)
                     .show();
         }
             else if(num<secret) {
                 result.setText("Bigger!");
             new AlertDialog.Builder(MainActivity.this)
                     .setTitle(":(")
                     .setMessage("bigger")
                     .setPositiveButton("OK",null)
                     .show();
             }
             else {
             result.setText("Got it!");
             new AlertDialog.Builder(MainActivity.this)
                     .setTitle(":)")
                     .setMessage("got it !")
                     .setPositiveButton("OK", null)
                     .show();
         }
        String num1 = "";
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
