package edu.uncw.seahawktours;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBar;

public class DetailActivity extends AppCompatActivity {

    Building[] buildings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Building build = new Building();
        buildings = build.createBuildings(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();
        int buildingPosition = intent.getIntExtra("BUILDING_POS",-1);
        System.out.println(buildingPosition);
        TextView buildName= (TextView) findViewById(R.id.building_name);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        TextView caption = (TextView) findViewById(R.id.caption);
        TextView description = (TextView) findViewById(R.id.paragraph);
        TextView url = (TextView) findViewById(R.id.url_2);

        for (Building b: buildings) {
            if (b.getPosition() == buildingPosition ){
                buildName.setText(b.getName());
                description.setText(b.getDescription());
                caption.setText(b.getCaption());
                image.setImageDrawable(b.getImage());
                url.setText(b.getUrl());

            }
        }

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
