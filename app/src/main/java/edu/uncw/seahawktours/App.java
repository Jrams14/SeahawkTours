package edu.uncw.seahawktours;

import android.app.Application;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import edu.uncw.seahawktours.Building;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the main data access object
        boxStore = MyObjectBox.builder().androidContext(App.this).build();



        // Get the wrapper (Box) for the Book table that lets us store Book objects
        Box<Building> buildingBox = boxStore.boxFor(Building.class);

        // Initialize with some data
        if (buildingBox.count() == 0) {
            List<Building> initialBuildings = new ArrayList<>();
            initialBuildings.add(new Building(getApplicationContext().getString(R.string.student_rec_name),34.222889,-77.867345,getApplicationContext().getString(R.string.student_rec_description),getApplicationContext().getString(R.string.student_rec_caption),"src","https://library.uncw.edu/web/collections/archives/bnl/34.html"));
            initialBuildings.add(new Building(getApplicationContext().getString(R.string.education_name),34.22690899999999,-77.86759080000002,getApplicationContext().getString(R.string.education_description),getApplicationContext().getString(R.string.education_caption),"education","https://library.uncw.edu/web/collections/archives/bnl/ed-bldg.html"));
            initialBuildings.add(new Building(getApplicationContext().getString(R.string.randall_name),34.2277492, -77.87422779999997,getApplicationContext().getString(R.string.randall_description),getApplicationContext().getString(R.string.randall_caption),"randall","https://library.uncw.edu/web/collections/archives/bnl/3.html"));
            initialBuildings.add(new Building(getApplicationContext().getString(R.string.burney_name),34.2247918, -77.87430359999996,getApplicationContext().getString(R.string.burney_description),getApplicationContext().getString(R.string.burney_caption),"burney","https://library.uncw.edu/web/collections/archives/bnl/15.html"));
            initialBuildings.add(new Building(getApplicationContext().getString(R.string.brooks_name),34.2218841,-77.87325850000002,getApplicationContext().getString(R.string.brooks_description),getApplicationContext().getString(R.string.brooks_caption),"brooks","https://library.uncw.edu/web/collections/archives/bnl/bbs.html"));

                buildingBox.put(initialBuildings);
        }
    }


    public BoxStore getBoxStore() {
        return boxStore;
    }
}