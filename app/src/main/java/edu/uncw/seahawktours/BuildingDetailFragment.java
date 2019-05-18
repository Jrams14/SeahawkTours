package edu.uncw.seahawktours;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.objectbox.Box;


public class BuildingDetailFragment extends Fragment {

    int position;
    private List<Building> buildingList;
    private Box<Building> buildingBox;

    public BuildingDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState !=null) {
            position = savedInstanceState.getInt("buildingPosition");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_building_detail, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();
        buildingBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Building.class);
        buildingList = buildingBox.getAll();
        View view = getView();
        if (view != null) {
            TextView buildName= (TextView) view.findViewById(R.id.building_name);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            TextView caption = (TextView) view.findViewById(R.id.caption);
            TextView description = (TextView) view.findViewById(R.id.paragraph);
            TextView url = (TextView) view.findViewById(R.id.url_2);

            buildName.setText(buildingList.get(position).getName());
            description.setText(buildingList.get(position).getDescription());
            caption.setText(buildingList.get(position).getCaption());
            int buildingImage = getContext().getResources().getIdentifier(buildingList.get(position).getImage(),"drawable",getContext().getPackageName());
            image.setImageResource(buildingImage);
            url.setText(buildingList.get(position).getUrl());


        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("buildingPosition",this.position);
    }

    public void setPosition(int pos) {
        this.position = pos;
    }

    public void setBuildingList(List<Building> buildings){
        this.buildingList = buildings;
    }
}
