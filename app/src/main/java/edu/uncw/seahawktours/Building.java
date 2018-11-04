package edu.uncw.seahawktours;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import edu.uncw.seahawktours.R;

public class Building {

        private String url;
        private String name;
        private int position;
        private String description;
        private String caption;
        private Drawable image;
        Building[] buildingList;
        Context context;

        public Building() {}

        private Building(String name,int position, String description, String caption, Drawable image, String url) {
                this.name = name;
                this.url = url;
                this.description = description;
                this.caption = caption;
                this.image = image;
                this.position = position;
        }

        public Building[] createBuildings(Context c) {
        Building[] buildings = {
                new Building(c.getString(R.string.student_rec_name),0,c.getString(R.string.student_rec_description),c.getString(R.string.student_rec_caption), ContextCompat.getDrawable(c,R.drawable.src),"https://library.uncw.edu/web/collections/archives/bnl/34.html"),
                new Building(c.getString(R.string.cis_name),1,c.getString(R.string.cis_description),c.getString(R.string.cis_caption), ContextCompat.getDrawable(c,R.drawable.cis),"https://library.uncw.edu/web/collections/archives/bnl/cis.html"),
                new Building(c.getString(R.string.randall_name),2,c.getString(R.string.randall_description),c.getString(R.string.randall_caption), ContextCompat.getDrawable(c,R.drawable.randall),"https://library.uncw.edu/web/collections/archives/bnl/3.html"),
        };

            buildingList = buildings;
            return buildings;
        }


        public String getUrl() {
                return url;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public String getCaption() {
                return caption;
        }

        public Drawable getImage() {
                return image;
        }

        public int getPosition() {
            return position;
        }


        @Override
        public String toString() {
                return this.getName();
        }
}
