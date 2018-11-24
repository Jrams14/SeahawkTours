package edu.uncw.seahawktours;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;


public class BuildingListSpinnerFragment extends Fragment {

    Building building = new Building();
    Building[] buildings;

    interface Listener {
        void itemClicked(int position);
    }

    private Listener listener;

    public BuildingListSpinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_building_list_spinner, container, false);
        buildings = building.createBuildings(getActivity());

        String[] buildingNames = new String[buildings.length];
        for (int i = 0; i < buildingNames.length; i++) {
            buildingNames[i] = buildings[i].getName();
        }

        Drawable[] drawables = new Drawable[buildings.length];
        for (int i = 0; i < drawables.length; i++) {
            drawables[i] = buildings[i].getImage();
        }

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(buildingNames, drawables);
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());


        recycler.setLayoutManager(layoutManager);
        return recycler;

    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        this.listener = (Listener)context;
//    }
//
//
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        View view = getView();
//        //Spinner buildingSpinner = (Spinner) getActivity().findViewById(R.id.buildings);
//        Spinner buildingSpinner = (Spinner)view;
//        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, building.createBuildings(view.getContext()));
//        buildingSpinner.setAdapter(listAdapter);
//        buildingSpinner.setSelected(false);
//
//        AdapterView.OnItemSelectedListener selectedListener= new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> listAdapter, View view, int position, long id) {
//                listener.itemClicked(position);
//            }
//            public void onNothingSelected(AdapterView<?> listAdapter) {
//
//            }
//        };
//        buildingSpinner.setOnItemSelectedListener(selectedListener);
//    }
}
