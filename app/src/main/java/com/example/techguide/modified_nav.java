package com.example.techguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class modified_nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static int Position;

    public static void getPosition(int position){
        Position=position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modified_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.modified_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_menuSettings) {
            Intent sendIntent = new Intent(modified_nav.this,SettingsActivity.class);
            startActivity(sendIntent);
            return true;
        }else if(id == R.id.action_menuShare){
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("application/vnd.android.package-archive");
            startActivity(sendIntent);
        }else if(id == R.id.action_menuDepartments){
            Intent intent = new Intent(modified_nav.this,MainActivity.class);
            startActivity(intent);
        }else if(id == R.id.action_menuAboutApp){
               Intent intent = new Intent(modified_nav.this,aboutApp.class);
              startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            startActivity(sendIntent);
        } else if (id == R.id.menu_courses) {
            //TODO POSITION
            if (Position==0){
               Intent intent=new Intent(modified_nav.this,ageCourses.class);
               startActivity(intent);
            }else if(Position==1){
              Intent intent=new Intent(modified_nav.this,cheCourses.class);
              startActivity(intent);
            }else if(Position==2){
                Intent intent=new Intent(modified_nav.this,cscCourses.class);
                startActivity(intent);

            }else if(Position==3){
                Intent intent=new Intent(modified_nav.this,cveCourses.class);
                startActivity(intent);

            }else if(Position==4){
                Intent intent=new Intent(modified_nav.this,eeeCourses.class);
                startActivity(intent);

            }else if(Position==5){
                Intent intent=new Intent(modified_nav.this,fstCourses.class);
                startActivity(intent);


            }else if(Position==6){
                Intent intent=new Intent(modified_nav.this,meeCourses.class);
                startActivity(intent);


            }else if(Position==7){
                Intent intent=new Intent(modified_nav.this,mseCourses.class);
                startActivity(intent);


            }

        } else if (id == R.id.menu_lecturers) {
            Intent intent =new Intent(modified_nav.this,selectTeacher.class);
            startActivity(intent);

        } else if (id == R.id.menu_departmental_Executives) {

        } else if (id == R.id.faculty_executives) {

        }else if(id == R.id.menu_send){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("application/vnd.android.package-archive");

            startActivity(sendIntent);
        }else if(id == R.id.menu_share){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("application/vnd.android.package-archive");

            startActivity(sendIntent);
        }



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
