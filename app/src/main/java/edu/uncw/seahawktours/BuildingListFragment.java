package edu.uncw.seahawktours;



import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;


public class BuildingListFragment extends Fragment {

    Building building = new Building();
    Building[] buildings;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public BuildingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_building_list, container, false);
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
        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                listener.onClick(position);
                }
        });
        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        return recycler;

    }

    @Override
    public void onAttach(Context context) {
        this.listener= (Listener)context;
        super.onAttach(context);

   }

}
