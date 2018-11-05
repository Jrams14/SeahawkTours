package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


public class MainActivity extends AppCompatActivity {

    Building building = new Building();
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner buildingSpinner = (Spinner) findViewById(R.id.buildings);
        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, building.createBuildings(this));
        buildingSpinner.setAdapter(listAdapter);
        buildingSpinner.setSelected(false);

        AdapterView.OnItemSelectedListener selectedListener= new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> listAdapter, View view, int position, long id) {
                if (++counter > 1) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("BUILDING_POS", position);
                    System.out.println(id);
                    startActivity(intent);
                }
            }
            public void onNothingSelected(AdapterView<?> listAdapter) {

            }
        };
        buildingSpinner.setOnItemSelectedListener(selectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.action_about:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }



}
