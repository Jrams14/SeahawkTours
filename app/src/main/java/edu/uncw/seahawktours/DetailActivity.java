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
        if (building.equals("CIS Building")){
            paragraph.setText(R.string.cisText);
            caption.setText(R.string.cisCap);
            image.setImageResource(R.drawable.cis);
        } else if(building.equals("Student Recreation Center")){
            paragraph.setText(R.string.studentRecText);
            caption.setText(R.string.studentRecCap);
            image.setImageResource(R.drawable.src);
        } else if(building.equals("Randall Library")) {
            paragraph.setText(R.string.randallText);
            caption.setText(R.string.randallCap);
            image.setImageResource(R.drawable.randall);
        }
    }
}
