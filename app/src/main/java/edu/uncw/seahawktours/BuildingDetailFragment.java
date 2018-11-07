package edu.uncw.seahawktours;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class BuildingDetailFragment extends Fragment {

    Building building = new Building();
    Building[] buildings;
    int position;

    public BuildingDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_building_detail, container, false);
    }

    @Override
    public void onStart() {
        buildings = building.createBuildings(getActivity());
        super.onStart();

        View view = getView();
        if (view != null) {
            TextView buildName= (TextView) view.findViewById(R.id.building_name);
            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            TextView caption = (TextView) view.findViewById(R.id.caption);
            TextView description = (TextView) view.findViewById(R.id.paragraph);
            TextView url = (TextView) view.findViewById(R.id.url_2);

            for (Building b: buildings) {
                if (b.getPosition() == this.position ){
                    buildName.setText(b.getName());
                    description.setText(b.getDescription());
                    caption.setText(b.getCaption());
                    image.setImageDrawable(b.getImage());
                    url.setText(b.getUrl());
                }
            }
        }
    }

    public void setPosition(int pos) {
        this.position = pos;
    }
}
