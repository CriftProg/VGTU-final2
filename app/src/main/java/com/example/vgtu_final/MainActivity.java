package com.example.vgtu_final;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationBar bar;

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bar = new NavigationBar(this);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new LecturesFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_lectures);
        }


    }



    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_lectures:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LecturesFragment()).commit();
                break;
            case R.id.nav_exams:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ExamsFragment()).commit();
                break;
            case R.id.nav_labs:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LabsFragment()).commit();
                break;
            case R.id.nav_options:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new OptionsFragment()).commit();

                //Intent intent = new Intent(this, OptionsActivity.class);
                //Log.i("Swipe", "Works");
                //this.startActivity(intent);
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}

