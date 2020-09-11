package com.example.digitalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public
class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Doctors App");

        drawer = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public
    boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_home:
              Intent homeIntent  = new Intent(DashBoardActivity.this,HomeActivity.class);
              startActivity(homeIntent);
              break;

            case R.id.news:
                Intent newsIntent = new Intent(DashBoardActivity.this,NewsActivity.class);
                startActivity(newsIntent);
                break;


            case R.id.specialists:
                Intent spIntent = new Intent(DashBoardActivity.this, SpecialistsActivity.class);
                startActivity(spIntent);
                break;

            case R.id.problems:
                Intent pIntent = new Intent(DashBoardActivity.this,DiseaseActivity.class);
                startActivity(pIntent);
                break;



        }
        return false;
    }
}