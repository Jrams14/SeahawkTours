package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    Building[] buildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Building build = new Building();
        buildings = build.createBuildings(this);


        Intent intent = getIntent();
        int buildingPosition = intent.getIntExtra("BUILDING_POS",-1);
        System.out.println(buildingPosition);
        TextView buildName= (TextView) findViewById(R.id.building_name);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView caption = (TextView) findViewById(R.id.caption);
        TextView description = (TextView) findViewById(R.id.paragraph);

        for (Building b: buildings) {
            if (b.getPosition() == buildingPosition ){
                buildName.setText(b.getName());
                description.setText(b.getDescription());
                caption.setText(b.getCaption());
                image.setImageDrawable(b.getImage());
            }
        }




    }
}
