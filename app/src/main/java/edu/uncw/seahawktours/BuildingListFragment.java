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
import android.view.accessibility.CaptioningManager;

import java.util.List;

import io.objectbox.Box;


public class BuildingListFragment extends Fragment implements CaptionedImageAdapter.Listener{

    Box<Building> buildingBox;
    List<Building> buildingList;

    private Listener listener;

    interface Listener {
        void onClick(int position,List<Building> buildingList);
    }

    public BuildingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        buildingBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Building.class);
        buildingList = buildingBox.getAll();
        RecyclerView recycler = (RecyclerView) inflater.inflate(R.layout.fragment_building_list, container, false);

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(buildingList,getContext());
        adapter.setListener(this);

        recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        return recycler;

    }

    @Override
    public void onAttach(Context context) {
        this.listener = (Listener)context;
        super.onAttach(context);

   }
    @Override
    public void onClick(int position) {
        listener.onClick(position,buildingList);
    }

}
