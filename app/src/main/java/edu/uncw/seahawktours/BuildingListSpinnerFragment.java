package edu.uncw.seahawktours;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;




public class BuildingListSpinnerFragment extends Fragment {

    Building building = new Building();
    static interface Listener {
        void itemClicked(int position);
    }

    private Listener listener;
    public BuildingListSpinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_building_list_spinner, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }

    //public void onStart() {
//        super.onStart();
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


    //}//

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        //Spinner buildingSpinner = (Spinner) getActivity().findViewById(R.id.buildings);
        Spinner buildingSpinner = (Spinner)view;
        ArrayAdapter<Building> listAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, building.createBuildings(view.getContext()));
        buildingSpinner.setAdapter(listAdapter);
        buildingSpinner.setSelected(false);

        AdapterView.OnItemSelectedListener selectedListener= new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> listAdapter, View view, int position, long id) {
                listener.itemClicked(position);
            }
            public void onNothingSelected(AdapterView<?> listAdapter) {

            }
        };
        buildingSpinner.setOnItemSelectedListener(selectedListener);
    }
}
