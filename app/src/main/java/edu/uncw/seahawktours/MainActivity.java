package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends Activity {

    Building building = new Building();
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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



}
