package com.lcu.cs.demodailyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lcu.cs.demodailyapplication.com.lcu.cs.TuLingNet.TuLingNet;
import com.lcu.cs.demodailyapplication.com.lcu.cs.bean.User;
import com.lcu.cs.demodailyapplication.com.lcu.cs.car.Car;
import com.lcu.cs.demodailyapplication.com.lcu.cs.tuling.tuLing;
import com.lcu.cs.demodailyapplication.com.lcu.cs.weather.Weather;
import com.lcu.cs.demodailyapplication.com.lcu.cs.word.Word;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        name = i.getStringExtra("userName");
       // TextView tv = (TextView) findViewById(R.id.UserName);
       // tv.setText(name);
        Log.i("username",name);

        setContentView(R.layout.activity_main);
       // TextView tv = (TextView) findViewById(R.id.UserName);
       // tv.setText(name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent ic = new Intent(MainActivity.this, TuLingNet.class);
            startActivity(ic);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        TextView tv = (TextView) findViewById(R.id.UserName);
        tv.setText(name);
        if (id == R.id.nav_weather) {
            Intent iw = new Intent(MainActivity.this, Weather.class);
            startActivity(iw);
        } else if (id == R.id.nav_logistics) {

            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        } else if (id == R.id.nav_word){
            Intent iwp = new Intent(MainActivity.this, Word.class);
            startActivity(iwp);

        } else if (id == R.id.nav_telephone) {
            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        } else if (id == R.id.nav_train) {
            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        } else if (id == R.id.nav_car) {
            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        } else if (id == R.id.tuling){
            Intent i = new Intent(MainActivity.this,tuLing.class);
            startActivity(i);
        } else if (id == R.id.nav_share){
            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        } else if (id == R.id.nav_info){
            Intent ic = new Intent(MainActivity.this, Car.class);
            startActivity(ic);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
