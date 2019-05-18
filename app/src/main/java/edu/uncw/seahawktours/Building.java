package edu.uncw.seahawktours;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Uid;

@Entity
public class Building {

        @Id
        public long id;
        private double buildingLongitude;
        private double buildingLatitude;
        private String url;
        private String name;
        private int position;
        private String description;
        private String caption;
        private String image;



        public Building() {}

        public Building(String name,double latitude, double longitude, String description, String caption, String image, String url) {
                this.name = name;
                this.url = url;
                this.description = description;
                this.caption = caption;
                this.image = image;
                this.position = position;
                this.buildingLatitude = latitude;
                this.buildingLongitude = longitude;
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

        public String getImage() {
                return image;
        }

        public int getPosition() {
            return position;
        }


        @Override
        public String toString() {
                return this.getName();
        }

        public double getBuildingLatitude() {
                return buildingLatitude;
        }

        public void setBuildingLatitude(double latitude) {
                this.buildingLatitude = latitude;
        }

        public double getBuildingLongitude() {
                return buildingLongitude;
        }

        public void setLongitute(double longitude) {
                this.buildingLongitude = buildingLongitude;
        }
}
