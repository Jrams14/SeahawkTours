package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String building = intent.getStringExtra("buildingName");
        TextView buildTextView = (TextView) findViewById(R.id.buildTextView);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView caption = (TextView) findViewById(R.id.caption);
        TextView paragraph = (TextView) findViewById(R.id.paragraph);
        buildTextView.setText(building);
        if (building == "Student Recreation Center"){
            paragraph.setText(R.string.cisText);
        }
    }
}
