package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchBuilding(View view) {
        Spinner buildingSpinner = (Spinner) findViewById(R.id.buildings);
        String selBuild = String.valueOf(buildingSpinner.getSelectedItem());
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra("buildingName",selBuild);
        startActivity(intent);
    }
}
