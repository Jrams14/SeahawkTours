package edu.uncw.seahawktours;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;


public class MainActivity extends AppCompatActivity implements BuildingListFragment.Listener {

    int position;
    private FusedLocationProviderClient mFusedLocationClient;
    private List<Building> buildingList;
    private Box<Building> buildingBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildingBox = ((App) getApplication()).getBoxStore().boxFor(Building.class);
        buildingList = buildingBox.getAll();
        System.out.println(buildingList.get(0).getBuildingLongitude());
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Here, thisActivity is the current activity
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                        // No explanation needed; request the permission
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1
                                );

                } else {
                    // Permission has already been granted
                    mFusedLocationClient.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                double lat = location.getLatitude();
                                double longitude = location.getLongitude();
                                // Initialize as 0
                                int posOfCloseBuilding = 0;
                                double smallDistance = Math.sqrt(Math.pow(lat - buildingList.get(0).getBuildingLatitude(),2) +
                                        Math.pow(longitude - buildingList.get(0).getBuildingLongitude(),2));


                                // Loop through buildings looking for closest building.
                                for (int i = 0;i < buildingList.size();i++){
                                    System.out.println(buildingList.get(i).getBuildingLatitude());
                                    double distance = Math.sqrt(Math.pow(lat - buildingList.get(i).getBuildingLatitude(),2) +
                                            Math.pow(longitude - buildingList.get(i).getBuildingLongitude(),2));
                                    if (distance < smallDistance) {
                                        smallDistance = distance;
                                        posOfCloseBuilding = i;
                                    }
                                }
                                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                                intent.putExtra("BUILDING_POS",posOfCloseBuilding);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(int position, List<Building> buildings) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            BuildingDetailFragment details = new BuildingDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setBuildingList(buildings);
            details.setPosition(position);
            ft.replace(R.id.fragment_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("BUILDING_POS",position);
            startActivity(intent);
        }
    }
}

